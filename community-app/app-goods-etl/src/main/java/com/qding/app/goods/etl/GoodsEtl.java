package com.qding.app.goods.etl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.app.goods.model.Goods;
import com.qding.app.goods.model.GoodsPublicsRelation;
import com.qding.app.goods.model.TagsGoodsRelation;
import com.qding.app.goods.service.GoodsPublicsRelationService;
import com.qding.app.goods.service.GoodsService;
import com.qding.app.goods.service.TagsGoodsRelationService;
import com.qding.common.constant.DaoConstant;

public class GoodsEtl {

	private static final int TASK_LEN = 100;// 一次任务检测的条数

	private static final long SLEEP_MILLISECOND = 2000;// 空转任务间隔休息毫秒数

	private static final Log log = LogFactory.getLog(GoodsEtl.class);

	// @Autowired
	private GoodsPublicsRelationService goodsPublicsRelationService;
	private TagsGoodsRelationService tagsGoodsRelationService;
	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public GoodsPublicsRelationService getGoodsPublicsRelationService() {
		return goodsPublicsRelationService;
	}

	public void setGoodsPublicsRelationService(GoodsPublicsRelationService goodsPublicsRelationService) {
		this.goodsPublicsRelationService = goodsPublicsRelationService;
	}

	public TagsGoodsRelationService getTagsGoodsRelationService() {
		return tagsGoodsRelationService;
	}

	public void setTagsGoodsRelationService(TagsGoodsRelationService tagsGoodsRelationService) {
		this.tagsGoodsRelationService = tagsGoodsRelationService;
	}

	public GoodsEtl() {
		super();
	}

	public void process1() throws InterruptedException {

		while (true) {

			try {
				// System.out.println("p1");
				processGoodsByTime();
			} catch (Throwable t) {

				t.printStackTrace();
				Thread.sleep(SLEEP_MILLISECOND);
				log.error("process goods bytime status error ,sleep " + t.getMessage());
			}
			
		}

	}

	public void process2() throws InterruptedException {

		while (true) {

			try {
				// System.out.println("p2");
				processGoodsByCount();
			} catch (Throwable t) {
				t.printStackTrace();
				Thread.sleep(SLEEP_MILLISECOND);
				log.error("process goods bycount status error ,sleep " + t.getMessage());
			}
		}

	}

	/**
	 * 检测过期商品，修改状态
	 * 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 * @throws InterruptedException
	 */
	private void processGoodsByTime() throws ServiceException, ServiceDaoException, InterruptedException {
		Map<String, Object> conditions = new HashMap<String, Object>();
		Date currentTime = new Date();
		// System.out.println(currentTime.getTime());
		conditions.put("status", "0");
		conditions.put("publish_end&<=", currentTime.getTime());
		List<Long> ids = goodsService.getIdsByDynamicCondition(Goods.class, conditions, 0, TASK_LEN);

		if (CollectionUtils.isEmpty(ids)) {
			log.info("not get any id ,sleep "+SLEEP_MILLISECOND+" ms ");
			Thread.sleep(SLEEP_MILLISECOND);
		} else {
			log.info("this task bytime find ids " + ids);
			update(ids);
		}

		// System.out.println(ids);

	}
	/**
	 * 检测无库存商品，修改状态
	 * 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 * @throws InterruptedException 
	 */
	private void processGoodsByCount() throws ServiceException, ServiceDaoException, InterruptedException {
		Map<String, Object> conditions = new HashMap<String, Object>();
//		Date currentTime = new Date();
		// System.out.println(currentTime.getTime());
		conditions.put("status", "0");
		conditions.put("count", "0");
		List<Long> ids = goodsService.getIdsByDynamicCondition(Goods.class, conditions, 0, TASK_LEN);


		if (CollectionUtils.isEmpty(ids)) {
			log.info("not get any id ,sleep "+SLEEP_MILLISECOND+" ms ");
			Thread.sleep(SLEEP_MILLISECOND);
		} else {
			log.info("this task bycount find ids " + ids);
			update(ids);
		}

		
		
		

	}
	private void updateGoods(List<Long> ids) throws ServiceException, ServiceDaoException {
		List<Goods> gl = goodsService.getObjectsByIds(ids);

		for (Goods g : gl) {
			if (g != null) {// 排除操作中被删除的可能S
				g.setStatus(DaoConstant.Status_Invalid);
				// gl.add(g);
			}

		}

		goodsService.updateList(gl);
		
		log.info("update updateGoods to Status_Invalid successd Goods ids:"+ids);
	}



	private void update(List<Long> ids) throws ServiceException,
			ServiceDaoException {
		updateTagRelation(ids);
		updatePublicsRelation(ids);
		updateGoods(ids);
	}

	private void updateTagRelation(List<Long> ids) {
		List<Long> alltgrl = new ArrayList<Long>();
		try {
			for (Long id : ids) {
				List<Long> tgrl = tagsGoodsRelationService.getTagsGoodsRelationIdsByGoodsID((id).longValue(), 0,
						Integer.MAX_VALUE);
				log.info("query by goods :"+id+",find tagrelationids"+tgrl);
				alltgrl.addAll(tgrl);
			}
			List<TagsGoodsRelation> tagsGoodsRelationList = tagsGoodsRelationService.getObjectsByIds(alltgrl);
			for (TagsGoodsRelation tagsGoodsRelation : tagsGoodsRelationList) {
				tagsGoodsRelation.setStatus(DaoConstant.Status_Invalid);
			}
			if (tagsGoodsRelationList.size()>0) {
				
				tagsGoodsRelationService.updateList(tagsGoodsRelationList);
				log.info("update  TagRelation to Status_Invalid successd tagsGoodsRelation ids:"+alltgrl);
			}else {
				log.info("no TagRelation to update for goods:"+ids);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("update tagsGoodsRelation status error goods ids:" + ids);
		}
	}

	private void updatePublicsRelation(List<Long> ids) {
		List<Long> alltgrl = new ArrayList<Long>();
		try {
			for (Long id : ids) {
				List<Long> tgrl = goodsPublicsRelationService.getGoodsPublicsRelationIdsByGoodsID(id, 0,
						Integer.MAX_VALUE);
				log.info("query by goods :"+id+",find publicrelationids"+tgrl);
				alltgrl.addAll(tgrl);
			}
			List<GoodsPublicsRelation> goodsPublicsRelationList = goodsPublicsRelationService.getObjectsByIds(alltgrl);
			for (GoodsPublicsRelation goodsPublicsRelation : goodsPublicsRelationList) {
				goodsPublicsRelation.setStatus(DaoConstant.Status_Invalid);
			}
			if (goodsPublicsRelationList.size()>0) {
				
				goodsPublicsRelationService.updateList(goodsPublicsRelationList);
				log.info("update PublicsRelation to Status_Invalid successd goodsPublicsRelation ids:"+alltgrl);
			}else {
				log.info("no PublicsRelation to update for goods:"+ids);
				
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("update goodsPublicsRelationService status error goods ids:" + ids);
		}
	}

}
