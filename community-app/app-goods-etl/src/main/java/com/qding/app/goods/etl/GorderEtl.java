package com.qding.app.goods.etl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.common.util.MyTimeUtil;
import com.qding.app.goods.model.Goods;
import com.qding.app.goods.model.GoodsPublicsRelation;
import com.qding.app.goods.model.Gorder;
import com.qding.app.goods.model.GorderGoodsRelation;
import com.qding.app.goods.model.TagsGoodsRelation;
import com.qding.app.goods.service.GoodsPublicsRelationService;
import com.qding.app.goods.service.GoodsService;
import com.qding.app.goods.service.GorderGoodsRelationService;
import com.qding.app.goods.service.GorderService;
import com.qding.app.goods.service.TagsGoodsRelationService;
import com.qding.common.constant.DaoConstant;
import com.qding.common.pay.service.PayOrderService;

public class GorderEtl {

	private static final int TASK_LEN = 100;// 一次任务检测的条数

	private static final long SLEEP_MILLISECOND = 60*1000;// 空转任务间隔休息毫秒数

	private static final Log log = LogFactory.getLog(GorderEtl.class);

	// @Autowired
	private PayOrderService payOrderService;
	private GorderService gorderService;
	
	private GorderGoodsRelationService gorderGoodsRelationService;
	private GoodsService goodsService;
 

	public GorderGoodsRelationService getGorderGoodsRelationService() {
		return gorderGoodsRelationService;
	}

	public void setGorderGoodsRelationService(
			GorderGoodsRelationService gorderGoodsRelationService) {
		this.gorderGoodsRelationService = gorderGoodsRelationService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public GorderService getGorderService() {
		return gorderService;
	}

	public void setGorderService(GorderService gorderService) {
		this.gorderService = gorderService;
	}

	public PayOrderService getPayOrderService() {
		return payOrderService;
	}

	public void setPayOrderService(PayOrderService payOrderService) {
		this.payOrderService = payOrderService;
	}

	public GorderEtl() {
		super();
	}

	public void process1() throws InterruptedException {

		while (true) {

			try {
				// System.out.println("p1");
				processGorderStatus();
			} catch (Throwable t) {
				t.printStackTrace();
				Thread.sleep(SLEEP_MILLISECOND);
				log.error("process gorder status  error ,sleep " + t.getMessage());
			}
			
		}

	}

	 
	/**
	 * 检测已付款待确认的订单
	 * 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 * @throws InterruptedException
	 */
	private void processGorderStatus() throws ServiceException, ServiceDaoException, InterruptedException {
		Map<String, Object> conditions = new HashMap<String, Object>();
		Date currentTime = new Date();
		// System.out.println(currentTime.getTime());
		conditions.put("status", Gorder.Status_Paying);
		conditions.put("type", "\""+Gorder.Type_online+"\"");
		conditions.put("pay_at&<", System.currentTimeMillis()-(13*60*1000));//设置13分钟有效期外的时间来进行检测
		conditions.put("@order", "update_at asc");
		List<Long> ids = gorderService.getIdsByDynamicCondition(Gorder.class, conditions, 0, TASK_LEN);
		
		if (CollectionUtils.isEmpty(ids)) {
			log.info("not get any id ,sleep "+SLEEP_MILLISECOND+" ms ");
			Thread.sleep(SLEEP_MILLISECOND);
		} else {
			log.info("get ids " + ids.size());
			log.info("this task ids " + ids);
			checkAndUpdate(ids);
		}

		// System.out.println(ids);

	}

 
 
	/**逐一检查，并根据返回结果修改状态
	 * @param ids
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	private void checkAndUpdate(List<Long> ids) throws ServiceException,
			ServiceDaoException {
		List<Gorder> objs = gorderService.getObjectsByIds(ids);
//		List<Gorder> waitupdateList=new ArrayList<Gorder>(); 
		for (Gorder gorder : objs) {
			System.err.println(gorder.getPayAt()+">>"+gorder.getId());
//			if (gorder.getStatus()==Gorder.Status_Paying) {//状态还是待修改那么调用接口检测
				if(checkOneStatus(gorder)){
					gorderService.update(gorder);
					log.info("update success gorderid:"+gorder.getId()+",to status:"+"("+gorder.getStatus()+")");
				}
//			}
		}
//		if (waitupdateList.size()>0) {
//			gorderService.updateList(waitupdateList);
//			log.info("this updatelist ok！！");
//		}else {
//			log.info("no gorder for update！！");
//		}
	}

	/**检查单个订单支付结果 ---目前使用随机数模拟
	 * @param gorder
	 * @return 是否修改了数据
	 */
	private boolean checkOneStatus(Gorder gorder) {
		
//		0：成功
//		1：失败
//		2：处理中
//		3：无此交易
//		4:查询本身失败
		String merchantOrderId = gorder.getCode();
		String merchantOrderTime =  MyTimeUtil.convertLong2String(gorder.getGorderAt(), "yyyyMMddHHmmss");
//		log.info(merchantOrderTime+">>>"+MyTimeUtil.convertLong2String(gorder.getCreateAt(), "yyyyMMddHHmmss")+">>>"+MyTimeUtil.convertLong2String(gorder.getGorderAt(), "yyyyMMddHHmmss"));
		try {
			String res = payOrderService.check(merchantOrderId, merchantOrderTime);
			
			log.info("查询订单支付状态结果："+res+",订单code："+merchantOrderId+",订单id："+gorder.getId());
			
			if ("0".equals(res)) {//0：成功
				setGoodsCount(gorder);
				gorder.setStatus(Gorder.Status_Pay_All);return true;
			}
			if ("1".equals(res)) {//1：失败
				gorder.setStatus(Gorder.Status_Pay_Failure);return true;
			}
			if ("3".equals(res)) {//3：无此交易 >> 同失败
				gorder.setStatus(Gorder.Status_Pay_Failure);return true;
			}
			if ("2".equals(res)) {//2：处理中
				return false;
			}
			if ("4".equals(res)) {//4:查询本身失败
				return false;
			}
			
			
			
		} catch (Throwable e1) {
			log.error("调用支付查询接口出错，merchantOrderId："+merchantOrderId);
			e1.printStackTrace();
			return false;
		}
		return false;
		
	}

	private void setGoodsCount(Gorder gorder) throws ServiceException, ServiceDaoException {
		if (gorder.getStatus() == Gorder.Status_Pay_All) {
			
			log.info(" update goods count start ");
			
			List<Long> ids = this.gorderGoodsRelationService.getGorderGoodsRelationIdsByGorderID(gorder.getId(), 0, Integer.MAX_VALUE);
			
			log.info(" update goods count , relation ids "+ids);
			
			List<GorderGoodsRelation> ggrList = this.gorderGoodsRelationService.getObjectsByIds(ids);
			
			log.info(" update goods count , relation size "+ggrList.size());
			
			List<Long> gids = new ArrayList<>();
			Map<Long,Integer>  numberMap = new HashMap<>();
			for (GorderGoodsRelation ggr : ggrList) {
				gids.add(ggr.getGoodsID());
				numberMap.put(ggr.getGoodsID(), ggr.getCount());
			}
			
			log.info("update goods count  ids "+gids);
			
			List<Goods> goodsList = this.goodsService.getObjectsByIds(gids);
			
			log.info("update goods count , goods size "+goodsList.size());
			
			for (Goods goods : goodsList) {
				if(goods.getCount() != -1){
					goods.setCount(goods.getCount()-numberMap.get(goods.getId()));
				}
			}
			
			goodsService.updateList(goodsList);
			
			log.info(" update goods count success");
			
			gorder.setStatus(Gorder.Status_Pay_All);
			gorderService.update(gorder);
		}
		
	}
	 

}
