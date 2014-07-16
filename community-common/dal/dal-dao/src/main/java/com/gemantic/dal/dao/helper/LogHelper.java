package com.gemantic.dal.dao.helper;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;

import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.ListLoadInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.ObjectUtil;

public class LogHelper {
    //====================Debug 级别的信息 ===========================================
	public static void debugSQL(Log log,String sql){
		if (log.isDebugEnabled()) {
			log.debug("SQL -->" + sql);
		}
	}
   
	public static void debugSQL(Log log,SqlInfo sqlInfo,boolean bAll,Number start,Number count){
//		log.warn("\r\n ===============Sql Info =============");
//		StringBuffer strBuf = new StringBuffer();
//		int paramCnt = 0;
//		if(null != sqlInfo.getParams() && sqlInfo.getParams().length >0){
//			paramCnt = sqlInfo.getParams().length;
//		}
//		strBuf.append(" \r\nsql --- >"+sqlInfo.getSql())
//		      .append("BAll -->"+bAll)
//		      .append(" start -->"+bAll)
//		      .append(" count -->"+count)
//		      .append(" params count -->"+paramCnt);
//		if(null != sqlInfo.getParams()){
//            for(Object obj:sqlInfo.getParams()){
//        	strBuf.append(" param -->"+obj);
//        }
//		}
//        log.warn(strBuf.toString()+"\r\n");
	}
	public static void debugSQL(Log log,SqlInfo sqlInfo){
//		log.warn("\r\n ===============Entity Sql Info =============");
//		StringBuffer strBuf = new StringBuffer();
//		int paramCnt = 0;
//		if(null != sqlInfo.getParams() && sqlInfo.getParams().length >0){
//			paramCnt = sqlInfo.getParams().length;
//		}
//		strBuf.append(" \r\nsql --- >"+sqlInfo.getSql())
//		      .append(" params count -->"+paramCnt);
//		if(null != sqlInfo.getParams()){
//            for(Object obj:sqlInfo.getParams()){
//        	strBuf.append(" param -->"+obj);
//        }
//		}
//        log.warn(strBuf.toString()+"\r\n");
	}
	
	public static void runningStartAndCount(Log log){
//		log.info(" \r\n =====Running start ,count");
	}
	public static void debugDataSource(Log log,String listName,Object account_id){
//		log.info("Using Datasource === > list  name-->"+listName+"  account_id :"+account_id);
	}
	
	// 记录在<已经配置了某个List的缓存，但用户从未访问过key值为 。。。的该List>
	public static void  cachedListUnVisited(Log log,LsCacheInfoHelper info){
		log.info("Attention : The List--"+info.getRegion()+ " with key"+ info.getRegion() + " with key --" + info.getKey()+ " doesn't exist in cache\r\n");		
	}
	
	//=====================Info 级别的信息 =============================================
	
	public static void mappingParams(Log log,Object accountId,String mappingName,Object[] params){
//		StringBuffer strBuf = new StringBuffer();
//		if(null != params && params.length >0){
//			for(Object obj: params){
//			  strBuf.append(" param -->"+obj);
//			}
//		}
//		log.warn("Attention: using getMapping  with accountId -->"+accountId+" ,mappingName --->"+mappingName+",params -->"+strBuf.toString());
	}
	public static void usingMappingWithCache(Log log){
//		log.warn(" Attention : Using Mapping with cache \r\n" );
	}
	public static void usingMappingWithDB(Log log){
//		log.info(" Attention : Using Mapping with DB \r\n" );
	}
	
    //=====================提醒性质的信息
	public static void objectHasBeenDeleted(Log log,Class clazz,Serializable id){
		log.info("Attention:The object of class:"+clazz.toString()+" with id -->" + id.toString()+ " has been deleted");
	}
	
	public static void cacheDontConfigured(Log log ,String region){
//		log.info("Warn : The cache for region " + region+ " cann't found");
	}
	
	//=====================提示性质的信息
	public static void saveObjectCausedANewListSection(Log log){
		log.info("Attention: The new saved id caused a new list section added");
	}
	
	public static void listHasNotVisited(Log log,String region,String key){
		log.warn("The List info :"+ region + " with key :" + key+ " doesn't exist in Cache or it's size is 0 \r\n");
	}
	
	//删除一笔记录时，导致缓存中的整个List重构
	public static void listReLoadWhenDeleting(Log log,String region,String key,Serializable id){
		log.info("The List :"+ region + " with key :"+ key + " is rebuilded  when deleting id :"+id);	
	}
	
	//查询count 数时，传入的list name或参数 为 null
	public static void listParamsNull(Log log,LsCacheInfoHelper lsHelper){
		;
	}
	//======================Warn 级别的信息 =============================================
	
	//当装载List时，ListInfo中记录的某一个Section的信息，和数据库中实际的信息不一致
	public static void listInfoNotMatchSectionInCache(Log log,LsCacheInfoHelper lsHelper,ListLoadInfo listLoadInfo,List idCacheList){
		log.warn("\r\nIn Dao.getIdList ---\r\n" +
				" The ListInfo of Region "+lsHelper.getRegion()+" ,key :"+lsHelper.getKey()+" 's visited SectionInfo not match with "+
				" the section info in cache of section "+listLoadInfo.sectionNo+" \r\n"+
				" The index in ListLoaderInfo is  "+listLoadInfo.indexInSection+",But the cache list's size is "+idCacheList.size()+"\r\n");
	}
	
	
	//当前List在缓存中共分n段存储，当需要加载第m段，且m>n时，加载失败
	public static void failedLoadListSection(Log log,LsCacheInfoHelper lsHelper,ListInfoHelper infoHelper,Object sectionNo){
		log.warn("The List : "+lsHelper.getRegion()+ " with key :"+lsHelper.getKey()+" 's max section no is -->"+infoHelper.getMaxSectionNo()+
				",but the section you require is "+sectionNo+"\r\n");
	}
	
	//缓存中的对象已经删除，不能重新加载
	public static void objectHasRemoved(Log log,String region,String key){
		log.warn("Attention : The object in region :"+region +" with key :"+key +" has been removed \r\n");
	}
	
	// 聚合用的sql 参数为 null
	public static void parameterIsNullOfSql(Log log,String sql){
		
	}
	
	// 根据id list从数据库中加载未在缓存中的数据库时，未从数据库中找到全部为加载 id
	public static void failedLoadObjectLsByIdLs(Log log,Class cls){
		
	}
	//批量加载Map时，从数据库中没有加载到指定数量的Maps
	public static void failedLoadMapsLsByParams(Log log,String mappname,List<Object[]> paramsList){
		
	}	
	
	public static void failedGetClassNameByListName(Log log,String listName){
		log.warn("Attention: Cant' get class name by list name :"+listName);
	}
    public static void failedGetObjectId(Log log,Object obj){
		log.warn("Attention:The object's id is null \r\n");
    }
	
	public static void failedGetObjectById(Log log,Object accountId,Class cls,Serializable id){
		log.warn("Failed load Object of Class -->"+cls.getName()+ ",id -->"+id+",account_id -->"+accountId + " from database");
	}
	
	
	
	//save时，装载跨库聚合List的最新一段Section失败
	public static void failedGetLastedSectonFormCacheForCross(Log log){
		
	}
	//装载某个List的某一个Section失败
	public static void failedLoadOneListSection(Log log,LsCacheInfoHelper lsInfo,Long secNo){
		log.error("Error: Failed loading section-"+secNo+ " for region :"+ lsInfo.getRegion()+ " key :"+ lsInfo.getKey() + " \r\n");
	}
	
	//执行数据库查询返回null
	public static void failedExecuteQueryFromDB(Log log,SqlInfo sqlInfo){
		
	}
	
	
	//update,delete
	public static void failedGetIdFromObject(Log log,Object obj){
		log.warn("Warn : The  id of object :"+obj+" is null when update/delete cache \r\n");
	}
    //update.delete
	public static void failedFindIdFromList(Log log,LsCacheInfoHelper info,Object id){
		log.error("Error: Failed find id:" + id + " in Region :"+ info.getRegion() + " Key:" + info.getKey());
	}
	

	//得到一个对象所对应的CrossAggrList的CrossAggrListItem 列表时，某一个元素为 null
	public static void nullCrossAggrListItem(Log log,Object obj){
		log.warn("Attention : one CrossAggrListItem of class "+obj.getClass().getName()+" is null \r\n");
	}
	
	//某个Object的keyProperty为null
	public static void nullKeyPropertyOfObject(Log log,String region ,Object obj){
		   log.warn("Warn: The params of obj "+obj+" for Region: "+region+" is null or empty \r\n");
	}
	
	
	//VisitHelper相关信息
	/**
	 * 加载ListInfo的锁，已经在 save /update /delete 时，被删除了。
	 * 出现这种情况的场景为: 缓存中的ListInfo对象为null,此时没有对象的 save/update/delete 操作，且没有其他人加载，
	 *                      用户在VisitHelper中的相应ConcurrentHashMap中进行加锁成功，并开始进行从数据库的加载动作，
	 *                      但当加载未完成时，发生了对象的 save/update/delete 动作，此时会先从VisitHelper中的
	 *                      ConcurrentHashMap中删除之前设置的ListInfo的锁，因此当之前的ListInfo加载成功，用户准备删除
	 *                      之前设置的锁时，发现该锁已经被删除了
	 */
	public static void listInfoLockHasBeenRemoved(Log log,String region,String key){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("LockWarn : The ListInfo Lock in VisitHelper.listInfoMaps with region: ")
		      .append(region)
		      .append(" key : ")
		      .append(key)
		      .append(" has been removed before by save|update|delete action ,so please check the listinfo in cache to avoid something wrong  ");
		log.warn(strBuf.toString());
	}
	public static void sectionLockHasBeenRemoved(Log log,String region,String key){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("LockWarn : The Section Lock in VisitHelper.idListMaps with region: ")
		      .append(region)
		      .append(" key : ")
		      .append(key)
		      .append(" has been removed before by save|update|delete action ,so please check the section infos in cache to avoid something wrong  ");
		log.warn(strBuf.toString());
	}
	
	
	
	
	//===============================Error 级别信息
	//save一个对象失败
	public static void savedError(Log log,Object obj){
		log.warn("Warn :Failed to save object of Class "+obj.getClass());
	}
	//delete一个对象失败
	public static void deleteError(Log log,Class cls,Object account_id,Serializable id,boolean delType){
		log.warn("Failed to delete Object with class :"+ cls + "  account_id :" + account_id+" id:"+id+ " del type :" + delType);
	}
	//update一个对象失败
	public static void updateError(Log log,Object obj){
		try{
		log.error("Error: Failed to update class :"+ obj.getClass().getName() + " with id:"+ ObjectUtil.getObjectId(obj) + " in database \r\n");
		}
		catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	//save一个对象到List的某个section时，该section已满，此时属于DAL 的 异常情况，需要把整个List重装 ，并进行一些特殊处理
	public static void errorAddObjectToListSection(Log log,LsCacheInfoHelper info,Number currentMaxSecNo){
		log.error("Exception: when adding one id to ListName:"+ info.getRegion() + " Key :" + info.getKey()
				+ " SectionNo:" + currentMaxSecNo
				+ " ,The Section is all ready full \r\n");
	}
	
	//
	//判断一个List 是否需要Rebuild时，抛出的异常
	public static void errorWhenJudgeListRebuild(Log log,ListInfo listInfo,Exception e){
		log.error("Exception : when judge whether the list should rebuild ,\r\n the listInfo : "
				  +listInfo+" ,\r\n The Caused exception is "+e.getMessage());
		e.printStackTrace(System.out);
	}
	//装载某个List的最新一段Section失败
	public static void errorLoadLatestListSection(Log log,LsCacheInfoHelper lsInfo){
		log.error("Error: Failed loading latest section for region :"+ lsInfo.getRegion()+ " key :"+ lsInfo.getKey() + " \r\n");
	}
	
}
