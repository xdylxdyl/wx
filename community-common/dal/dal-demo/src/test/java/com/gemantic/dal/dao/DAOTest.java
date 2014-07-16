package com.gemantic.dal.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.core.dbsupport.DefaultSQLHandler;
import org.unitils.core.dbsupport.SQLHandler;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

import com.gemantic.analyse.dal.demo.model.Group;
import com.gemantic.analyse.dal.demo.util.Constants;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.impl.CompositeDaoImpl;
import com.gemantic.dal.dao.impl.DBDaoImpl;
import com.gemantic.dal.dao.util.AnnotationUtil;


/**
 *该测试只针对dao的操作，没有配置缓存,会有缓存的log输出warn
 * TODO: 1 为什么返回值用Serializable ?
 * TODO: 2 多线程混合操作，会有什么问题？
 * 
 * 
 *
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({"classpath:/META-INF/dal-demo/applicationContext-db.xml"})
public class DAOTest extends TestCase
{
    private static final Log log = LogFactory.getLog(DAOTest.class);
	private Group group;
	@SpringBeanByName
	Dao dao ;

	@SpringBeanByName
	private DataSource dbJijin;
	
	@SpringBeanByName
	private DataSource dbResearchReport;
	
	
	@Test
	public void emptyMethodForHudson(){
		log.info(" go ");
		
	}
//	@Test
	public void testSaveIntoDS(){
		Group group = new Group();
		group.setCreatedAt(System.currentTimeMillis());
		group.setName("测试RealSave");
		try {
			Long idFromSession = (Long) dao.save(group);
			Thread.sleep(5000L);
			log.warn("after 5 secends !");
			String sql = "select name from groups where id = "+idFromSession;
			SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
			log.warn("验证sql "	+sql);
			String name =sqlHandler.getItemAsString(sql);
			log.warn(" return name ="+name);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		
		
	}
	
	//-----------------------------插入数据-------------------------------------//
    /**
     * 1:单个对象的插入
     * 
     * 注意，
     * 这样的数据查询的时候需要注意分库的字段，如果不给给定分库字段的值，查询的时候也是找第一个配置的数据库，那么未必找得到
     * 如果要分库查询，一定要分库存储
     * 另外一个测试方法：
     * dao.save(object) ==== 》如果save的时候没有指定数据库，就会找第一个配置的数据库；
     */
//	@Test
    public void testSaveIntoDiffDS()
    {
		Map<Long,Long> map = new HashMap<Long,Long>();
		for(int i = 0;i<10;i++){
    	Group group = new Group();
    	group.setUpdatedAt(System.currentTimeMillis());
    	group.setCreatedAt(System.currentTimeMillis());
    	group.setName("*组(---)"+i);
    	group.setUserId(new Long(i));
    	try {
    		Long user_id =new Long(i);
			Long id = (Long) dao.save(user_id,group);
			map.put(user_id, id);
			log.warn("after save return id===="+id);
		} catch (DaoException e) {
			log.error(e);
		}
		}
		
		//验证插入的数据是否正确
		String sql = "select id from groups where id = xx and user_id = yy ";
		for(Entry entry : map.entrySet()){
			SQLHandler sqlHandler = null;
			if((Long)entry.getKey() < 5L){
				 sqlHandler = new DefaultSQLHandler(dbJijin);	
			}else{
				 sqlHandler = new DefaultSQLHandler(dbResearchReport);
			}
			sql = sql.replace("xx", String.valueOf(entry.getValue())).replace("yy", String.valueOf((Long)entry.getKey()));
			log.warn("验证sql "+sql);
			Long id =sqlHandler.getItemAsLong(sql);
			assertEquals(entry.getValue(),id);
			sql  = "select id from groups where id = xx and user_id = yy ";
		}
		
    }
	
	/**
	 * 2： 批量对象的保存
	 * 
	 * 批量存储只能保存数据到一个数据库，不能分库，例子是不分库的例子
	 * 下面是分库的方式：hibernateTemplate.save();
	 * dao.batchSave(acount_id, list);
	 */
//	@Test
	public void testBatchSaveToOneDS(){
		List list = new ArrayList();
		List<Group> groups = null;
		for(int i = 0;i<10;i++){
	    	Group group = new Group();
	    	group.setUpdatedAt(System.currentTimeMillis());
	    	group.setCreatedAt(System.currentTimeMillis());
	    	group.setName("批"+i);
	    	group.setUserId(9L);
	    	list.add(group);
		}
		try {
		groups =dao.batchSave(list); //存储到到默认的数据库
		} catch (DaoException e) {
			log.error(e);
		}
		
		
		//验证插入的数据是否正确
		String sql = "select id from groups where id = yy ";
		SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
		for(Group group :groups){	
			sql = sql.replace("yy", String.valueOf(group.getId()));
			log.warn("验证sql "+sql);
			Long resultId =sqlHandler.getItemAsLong(sql);
			assertEquals(resultId,group.getId());
			sql = "select id from groups where id = yy ";
		}
		log.warn("验证无误，通过！");
		
	}
	

	


	
	//-----------------------------删除数据-------------------------------------//
	/**
	 * 1：删除单个数据
	 * 
	 * 
	 * 删除某一个数据，如果没指定分库字段，则到默认的数据库中删除
	 * dao.delete(account_id, clazz, id)带有分库字段的删除
	 * 
	 * 
	 */
//	@Test 
	public void testDeleteObject(){
		Group group =null;
		try {
			group =(Group) dao.get(Group.class, 2882L);
			log.warn("获取数据GROUP ID ="+group.getId()+" NAME ="+group.getName());
			dao.delete(Group.class, group.getId());
			log.warn("删除数据 group id = "+group.getId());
		} catch (DaoException e) {
			log.error(e);
		}
		
		//验证插入的数据是否正确
//		String sql = "select id from groups where id = yy ";
//		SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
//			sql = sql.replace("yy", String.valueOf(group.getId()));
//			Long resultId =sqlHandler.getItemAsLong(sql);
//			assertEquals(resultId,null);
//		log.warn("验证无误，通过！");
	}
	
	/**
	 * 2：删除list
	 * 
	 * 带有分库字段的删除，注意删除的时候分库字段也必须和数据的真实字段保持一致，因在删除前有get,get里面有分库字段真实性的验证；
	 * 删除某一个数据，如果没指定分库字段，则到默认的数据库中删除
	 * dao.deleteList(clazz, ids);
	 * 
	 */
//	@Test 
	public void testDeleteObjectListFromOneDS(){
		try {
			List<Long> list = new ArrayList<Long>();
			list.add(1117L);
			list.add(1118L);

			dao.deleteList(new Long(5),Group.class, list);

		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	
	/**
	 * 3：根据查询语句删除List数据
	 * 
	 *根据sql语句删除所有的相关的数据
	 *其中的逻辑是：首先验证结果集的count,然后sql查询出相关的idList，然后dao.deleteList();
	 * dao.deleteList(list_name, param)
	 * dao.deleteList(list_name, params)
	 * dao.deleteList(account_id, list_name, param);
	 */
//	@Test 
	public void testDeleteObjectListBySql(){
		try {
			dao.deleteList(7L, Constants.GROUP_SQL_GETIDBYUSERID, new Object[]{7L});	
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * TODO:4：假删除  未测试
	 * 
	 * 就get有最后的验证分库字段是否正确，其他的方法没有验证。。。？
	 * dao.fakeDelete(clazz, id); ==》这个设计到新的配置，暂时在例子中没有找到，优先级最低
     * 这个假删除，也是更新了数据库的删除标记的字段
	 */
//	@Test
//	public void testFakeDeleteObjById(){
//		try {
//			dao.fakeDelete(24L, Group.class,1948L);
//		} catch (DaoException e) {
//			log.error(e);
//		}
//	}
//	@Test
//	public void testFakeDeleteObjsByIds(){
//		dao.fakeDeleteList(account_id, clazz, ids)
//	}
//	@Test
//	public void testFakeDelete(){
//		dao.fakeDeleteList(account_id, list_name, params);
//	}
	
	
	//-----------------------------更新数据-------------------------------------//
	/**
	 * 1：更新单个对象
	 * 
	 * 更新操作,根据一个对象更新
	 * dao.update(account_id, object)
	 * 
	 */
//	@Test
	public void testUpdateObject(){
		try {
			Group group = (Group) dao.get(Group.class, 1120L);
			log.warn("get Group object from db name ="+group.getName());
			group.setName("updatedName");
			dao.update(group);
			
			//验证插入的数据是否正确
		    String sql = "select name from groups where id = yy ";
		    SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
				sql = sql.replace("yy", String.valueOf(group.getId()));
				String name =sqlHandler.getItemAsString(sql);
				assertEquals(name,"updatedName");
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * 2：更新list
	 * 
	 * 更新操作,根据一组对象更新
	 * 内部的更新是批量的session.update(),然后session.commit()
	 * 
	 */
//	@Test
	public void testUpdateListObjects(){
		try {
		    List ids  = new ArrayList();
			ids.add(1122L);
			ids.add(1217L);
			ids.add(1218L);
			List<Group> objs =null;
			objs =dao.getList(15L,Group.class,ids);
		    for(Group group :objs){
		    	group.setName("updated组");
		    }
			dao.updateObjs(objs);
			
			
			//验证插入的数据是否正确
			String sql = "select name from groups where id = yy ";
			SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
			for(Group group :objs){	
				sql = sql.replace("yy", String.valueOf(group.getId()));
				log.warn("验证sql "+sql);
				String name =sqlHandler.getItemAsString(sql);
				assertEquals("updated组",name);
				sql = "select name from groups where id = yy ";
			}
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * 3：批量更新
	 * 
	 * 内部其实是单个更新for(){update(obj)}
	 * 会有分库字段的验证
	 * dao.batchUpdate(objects)不分库的更新
	 * 
	 * 
	 */
//	@Test
	public void testBatchUpdateListObjects(){
		try {
			List ids  = new ArrayList();
			ids.add(1220L);
			ids.add(1222L);
			ids.add(1327L);
			List<Group> objs =null;
			try {
				objs =dao.getList( 8L,Group.class,ids);
				for(Object obj: objs){
					log.warn(((Group)obj).getName());
				}
			} catch (DaoException e) {
				log.error(e);
			}
		 
			
		    for(Group group :objs){
		    	group.setName("小朋友组");
		    }
			dao.batchUpdate(8L, objs);
			
			
			//验证插入的数据是否正确
			String sql = "select name from groups where id = yy ";
			SQLHandler sqlHandler = new DefaultSQLHandler(dbResearchReport);
			for(Group group :objs){	
				sql = sql.replace("yy", String.valueOf(group.getId()));
				log.warn("验证sql "+sql);
				String name =sqlHandler.getItemAsString(sql);
				assertEquals("小朋友组",name);
				sql = "select name from groups where id = yy ";
			}
			
			
			
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	
	//-----------------------------根据sql查询数据的数量-------------------------------------//
	/**
	 *  
	 * 用到的sql不需要单独配置，必须用配置为List类型的sql
	 * int dao.count(Object list_name, Object param)
	 * int dao.count(String list_name, Object[] params)
	 * int dao.count( Object account_id, String list_name, Object param)
	 * int count(Object account_id, String list_name, Object[] params)
	 * 参数说明：acount_id：分库字段  Long
	 * 			 list_name: dao.xml配置中的属于object的list类型的sql语句
	 *           param  sql的参数
	 *           params sql的多个参数
	 *           
	 * 
	 */
//	@Test
	public void testCount(){
		try {
			
			int count = dao.count(1L, Constants.GROUP_SQL_GETIDBYUSERID, new Object[]{1L});
			log.warn("count = ================"+count);
		} catch (DaoException e) {
			log.error(e.message);
		}
	}

	
	//-----------------------------查询数据-------------------------------------//
	/**
	 * 1: 根据Id单对象查询
	 * 
	 * 无分库的字段，通过主键到默认的数据库查询
	 * 
	 */
//	@Test
	public void testGetObject(){
		try {
	   
		Group group = (Group)dao.get(Group.class, 1582L);
		log.warn("group.id = "+group.getId()+" ; group.name= "+group.getName()+" ; group.CreatedAt = "+group.getCreatedAt());
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	
	
	/**
	 * 
	 * 2：分库根据Id单对象查询
	 * 
	 * 根据策略字段找到相应的集群库，然后读取master和slave库中的数据，如果没有slave则读取master中的数据
	 * 如果没有策略字段则寻找默认策略中配置的第一个的数据库。
	 * 注意策略字段在dao.xml中的配置，应该和数据库中的值相同，因为最后的会有验证的代码DalAssert
	 * 
	 * 如果要分库查询，一定要分库存储
     * 这样的数据查询的时候需要注意分库的字段，如果不给定分库字段的值，查询的时候也是找第一个配置的数据库，那么未必找得到
	 * 
	 */
//	@Test
	public void testGetObjectFromOneDS(){
		try {
			Group group =(Group)dao.get(4L, Group.class, 1736L);
			log.warn("group.name ="+group.getName()+";group.id ="+group.getId());
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * 3：根据id的List查询出Object的List
	 * 
	 * 根据类和主键值找到所需要的类
	 * 此方法不能用在多库查询的时候，原因是分库的参数此处是单值的，可以分库单独查询
	 * get*List的方法都不能用在多库查询的地方，因为count_id是单个的参数
	 */
//	@Test
	public void testGetObjectsListByIds(){
		List ids  = new ArrayList();
		ids.add(2763L);
		ids.add(2764L);
		ids.add(2765L);
		List objs =null;
		try {
			objs =dao.getList(12L,Group.class,ids);
			for(Object obj: objs){
				log.warn(((Group)obj).getName());
			}
		} catch (DaoException e) {
			log.error(e);
		}
	}
		
	/**
	 * 4：根据sql查询出id的list
	 * 
	 * 根据配置文件中定制的语句来查询数据，第一个参数策略参数（暂时发现没有起作用），
	 * 第二个参数，配置文件中查询语句的名字
	 * 第三个参数查询语句中的参数
	 * 第四个参数从查询的数据集中起始位置查找数据
	 * 第五个参数查找多少行数据
	 * 第六个参数 true的时候 :select id from groups where user_id = ? order by id desc
	 * 第六个参数 false的时候:select id from groups where user_id = ? order by id desc
	 * 
	 * List getIdList(String list_name, Object param, boolean forward)
	 * List getIdList(String list_name, Object[] params, boolean forward)
	 * List getIdList(Object account_id, String list_name, Object param,boolean forward)
	 * List getIdList(Object account_id, String list_name, Object[] params,boolean forward)
	 * List getIdList(String list_name, Object[] params, Integer start,Integer count, boolean forward)
	 * List getIdList(String list_sql_name, Object param, Integer start,Integer count, boolean forward) 
	 * List getIdList(Object account_id, String list_name, Object param,Integer start, Integer count, boolean forward)
	 * List getIdList(Object account_id, String list_name, Object[] params,Integer start, Integer count, boolean forward)
	 * 
	 * 
	 * 
	 */
//	@Test
	public void  testGetIdListBySql(){
		
		try {
			List ids =dao.getIdList(0L,Constants.GROUP_SQL_GETIDBYUSERID, new Object[]{0L}, 0, 10, false);
			for(Object id:ids){
				log.warn("return id ="+id);
			}
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	
	/**
	 * 5:根据多个参数查询数据
	 * 
	 * map查询中是针对了多个参数的查询
	 * 根据Object[]的一组参数 查询出一个id
	 * TODO:同一组参数，多个返回值，如何处理？
	 */
//	@Test
	public void testGetIdByparamObjArray(){
		Object[] params = new Object[]{1299587757437L,4L};
		try {
			Object id =dao.getMapping(new Long(4), Constants.GROUP_SQL_GETIDBYCREATEDATANDUSER_ID, params);
			log.warn("param creat_at ="+params[0]+"param user_id = "+params[1]+ "return id =" +id);
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * 6:根据参数list，得到id的list针对的是单个库
	 * 
	 * 根据List<Object[]>类型的参数，来查询符合条件的list
	 * 中文参数没问题
	 * TODO:同参数，多个返回值是怎么处理的？
	 */
//	@Test
	public void testGetIdsByparamObjslist(){
		List<Object[]> paramsList = new ArrayList<Object[]>();
		 Object[] params = new Object[]{"大大組11",11L};
		paramsList.add(params);
		try {
			List ids =dao.getMappings(new Long(1), Constants.GROUP_SQL_GETIDBYNAMEANDUSER_ID, paramsList);
			for(Object id:ids){
				log.warn( "return id =" + id);
			}
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	/**
	 * 
	 * 7：读数据库多参数的查询
	 * 
	 * 通过路由，在多个db的group中，根据不同的参数值查询不同的值：
	 * 逻辑如下：
	 * 1：找到对应的object所配置的策略，然后再根据配置的路由字段来路由到不同的数据库的group
	 * 2：根据是读库是用的是slave，写库写的是master，如果读库中没有slave，则使用master
	 * 3：对于根据配置的策略找到的数据库，他们是和参数的Object[]是一对一的；
	 * 
	 * 根据多个路由，List的参数查询出List的值
	 */
//	@Test
	public void testGetIdsByParamObjslistAndCount_idArray(){
		List<Object[]> paramsList = new ArrayList<Object[]>();
		 Object[] params1 = new Object[]{1299482901609L,3L};
		 Object[] params2 = new Object[]{1299587878093L,9L};
		paramsList.add(params1);
		paramsList.add(params2);
		List count_list =new ArrayList();
		count_list.add(3L);
		count_list.add(9L);
		try {
			List ids =dao.getMapList(count_list, Constants.GROUP_SQL_GETIDBYCREATEDATANDUSER_ID, paramsList);
			for(Object id:ids){
				log.warn("getMapList return id = "+id);
			}
		} catch (DaoException e) {
			log.error(e);
		}
	}
	
	
	//获取最大的Id，支持分库
//	@Test
	public void testGetMaxIdOfClass(){
		try {
			log.warn(dao.getMaxIdOfClass(Group.class));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}
	
	//测试新增的AnnotationUtil
//	@Test
	public void getAnnotation(){
		Class groupClass = Group.class;
		log.warn(AnnotationUtil.getTableNameFromEntity(groupClass));
		log.warn(AnnotationUtil.getIdClumnFromEntity(groupClass));
	}
	
//	@Test
	public void testMutiOperartion(){
		Group group = new Group();
		group.setCreatedAt(System.nanoTime());
		group.setName("mutiOpt");
		group.setUserId(1L);
		
		try {
			dao.save(group);
			group.setName("Yes!");
			dao.update(group);
			dao.delete(Group.class,group.getId());
		
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
	public void testgetListTime() {
		
		Object obj;
		try {
			obj = dao.getIdList("getReserch_Id", 0L, true);
			log.warn(obj.toString());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用于测试多线程下IdGenerator
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t =null;
		for(int i =0;i<10;i++){
			t =new Thread(new MyRunnable(i));
			t.start();
		}
		

		
	}
	
}
class MyRunnable implements Runnable{
	Dao dao =  new CompositeDaoImpl();
	private static final Log log = LogFactory.getLog(MyRunnable.class);
	private int place;
	public MyRunnable(int place){
		this.place = place;
	}
	public MyRunnable(){
	}
	@Override
	public void run() {
		for(int j =0 ;j<20;j++){
			Group group =new Group();
			group.setUserId(new Long(j));
			group.setName("--"+"j="+j);
			try {
				Long id =(Long) dao.save(new Long(j),group);
				log.warn("第"+place+"个线程,第 "+j+" 次保存 数据到 数据库，返回的 id = "+ id);
			} catch (DaoException e) {
				log.error(e);
			}
		}
	}
	
}




