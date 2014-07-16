package com.gemantic.dal.dao.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.Type;
import org.hibernate.type.TypeFactory;

import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ListItem;
import com.gemantic.dal.config.model.dao.MapItem;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.ScalarInfo;
import com.gemantic.dal.dao.model.SqlInfo;

public class SqlUtil {
    private static Log log = LogFactory.getLog(SqlUtil.class);

    public static final  int IN_CNT =10;
    public static final  int UNION_CNT=30;
    /**
     * @param mappingName
     * @param params
     * @param bExtend     :用于决定是否是扩展类型的Map ,对于扩展类型的Map，允许在一个Map中返回多个值
     * @return
     */
    public static SqlInfo getMappingSqlInfo(String mappingName, Object[] params, boolean bExtend) {
        SqlInfo sqlInfo = null;
        MapItem mapItem = DaoHelper.getMapItemByMapName(mappingName);
        String sql = mapItem.getSqlitem();
        if (!bExtend) {
            String column = DaoHelper.getMapItemValueColumnName(mappingName);
            Type type = TypeFactory.basic(DaoHelper.getMapItemValueClass(mappingName).getName());
            ScalarInfo scalarInfo = new ScalarInfo(column, type);
            List<ScalarInfo> scaList = new ArrayList<ScalarInfo>();
            scaList.add(scalarInfo);
            sqlInfo = new SqlInfo(sql, params, scaList);
        } else {
            sqlInfo = new SqlInfo(sql, params, null);
        }

        return sqlInfo;
    }

    public static SqlInfo getListSql(String listName, Object[] params, boolean bReverse) {
        if (bReverse) {
            return getReverseListSql(listName, params);
        } else {
            return getAscListSql(listName, params);
        }
    }

    public static SqlInfo getListSql(LsCacheInfoHelper lsHelper, boolean bReverse) {
        if (null == lsHelper || null == lsHelper.getRegion()) {
            LogHelper.listParamsNull(log, lsHelper);
            return null;
        } else {
            return getListSql(lsHelper.getRegion(), lsHelper.getParams(), bReverse);
        }
    }

    private static SqlInfo getAscListSql(String listName, Object[] params) {
        Integer listType = ObjectUtil.getListType(listName);
        SqlInfo sqlInfo = null;
        String sql = null;
        final ListItem listItem = DaoHelper.getListItemByListName(listName);
        switch (listType) {
            case Constants.COMMON_TYPE:
                sql = listItem.getSqlitem();

                String iDColumn = listItem.getColumnName();
                Type type = TypeFactory.basic(DaoHelper.getListItemValueClass(listName).getName());

                ScalarInfo scalarInfo = new ScalarInfo(iDColumn, type);
                List<ScalarInfo> scaList = new ArrayList<ScalarInfo>();
                scaList.add(scalarInfo);

                sqlInfo = new SqlInfo(sql, params, scaList);
                break;
            case Constants.CROSSDB_TYPE:
                sql = listItem.getSqlCross();

                String idColumn = listItem.getColumnName();
                Type idTtype = TypeFactory.basic(DaoHelper.getListItemValueClass(listName).getName());

                ScalarInfo idScalarInfo = new ScalarInfo(idColumn, idTtype);

                //以下部分需要永华提供实现
                //Account Scalar
                String accountColumn = listItem.getStrategyColumn();
                ScalarInfo accountScalarInfo = new ScalarInfo(accountColumn, null);

                //CreateTime Scalar
                String createTimeColumn = listItem.getCrossOrderByColumn();
                ScalarInfo createTimeScalarInfo = new ScalarInfo(createTimeColumn, null);

                List<ScalarInfo> crossScaList = new ArrayList<ScalarInfo>();
                crossScaList.add(idScalarInfo);
                crossScaList.add(accountScalarInfo);
                crossScaList.add(createTimeScalarInfo);

                sqlInfo = new SqlInfo(sql, params, crossScaList);
                break;
            default:
                break;
        }
        //取出要查询到的栏位的信息
        return sqlInfo;
    }

    private static SqlInfo getReverseListSql(String listName, Object[] params) {
        Integer listType = ObjectUtil.getListType(listName);
        SqlInfo sqlInfo = null;
        String sql = null;
        final ListItem listItem = DaoHelper.getListItemByListName(listName);
        switch (listType) {
            case Constants.COMMON_TYPE:
                sql = listItem.getReverseSql();

                String iDColumn = listItem.getColumnName();
                Type type = TypeFactory.basic(DaoHelper.getListItemValueClass(listName).getName());

                ScalarInfo scalarInfo = new ScalarInfo(iDColumn, type);
                List<ScalarInfo> scaList = new ArrayList<ScalarInfo>();
                scaList.add(scalarInfo);

                sqlInfo = new SqlInfo(sql, params, scaList);
                break;
            case Constants.CROSSDB_TYPE:
                sql = listItem.getReverseSqlCross();

                String idColumn = listItem.getColumnName();
                Type idTtype = TypeFactory.basic(DaoHelper.getListItemValueClass(listName).getName());

                ScalarInfo idScalarInfo = new ScalarInfo(idColumn, idTtype);

                //以下部分需要永华提供实现
                //Account Scalar
                String accountColumn = listItem.getStrategyColumn();
                ScalarInfo accountScalarInfo = new ScalarInfo(accountColumn, null);

                //CreateTime Scalar
                String createTimeColumn = listItem.getCrossOrderByColumn();
                ScalarInfo createTimeScalarInfo = new ScalarInfo(createTimeColumn, null);

                List<ScalarInfo> crossScaList = new ArrayList<ScalarInfo>();
                crossScaList.add(idScalarInfo);
                crossScaList.add(accountScalarInfo);
                crossScaList.add(createTimeScalarInfo);

                sqlInfo = new SqlInfo(sql, params, crossScaList);
                break;
            default:
                break;
        }
        //取出要查询到的栏位的信息
        return sqlInfo;
    }


    public static SqlInfo getListCountSql(String listName, Object[] params) {
        Integer listType = ObjectUtil.getListType(listName);
        SqlInfo sqlInfo = null;
        String sql = null;
        final ListItem listItem = DaoHelper.getListItemByListName(listName);
        switch (listType) {
            case Constants.COMMON_TYPE:
                sql = listItem.getSqlcountitem();
                sqlInfo = new SqlInfo(sql, params, null);
                break;
            case Constants.CROSSDB_TYPE:
                sql = listItem.getSqlCrossCount();
                sqlInfo = new SqlInfo(sql, params, null);
                break;
            default:
                break;
        }
        //取出要查询到的栏位的信息
        return sqlInfo;
    }

    public static SqlInfo getListCountSql(LsCacheInfoHelper lsHelper) {
        return getListCountSql(lsHelper.getRegion(), lsHelper.getParams());
    }


    //得到跨库查询中，加载缓存中某一个section的sql.
    public static SqlInfo getCrossDBSectionSql(String listName, Object[] params1, Object[] params2) {
        SqlInfo sqlInfo = null;
        final ListItem listItem = DaoHelper.getListItemByListName(listName);
        if (null == listItem.getType() || Constants.CROSSDB_TYPE != listItem.getType()) {
            return null;
        }
        String sql = listItem.getSqlCrossSecion();
        List paramList = new ArrayList();
        for (Object obj : params1) {
            paramList.add(obj);
        }
        for (Object obj : params2) {
            paramList.add(obj);
        }
        sqlInfo = new SqlInfo(sql, paramList.toArray(), null);
        return sqlInfo;
    }


    //用于得到聚合需要的执行的SqlInfo 的List
    public static List<SqlInfo> getMapAggreSqlInfos(String mapName, List<Object[]> paramsList) {
        final MapItem mapItem = DaoHelper.getMapItemByMapName(mapName);
        return getUnionSql(paramsList, mapItem.getSqlitem(), null);
    }


    //==========================================以下是聚合时需要的方法
//	
//    //这是另一种方式，未来可以试验，是否可行	
//	//得到5个in，6个union的sql
//	public static List<SqlInfo>  getUnionSql(List<Object[]> paramsList,final String baseSql,List<Type> returnTypes) {
//		List<SqlInfo> sqlInfoList= new ArrayList<SqlInfo>();
//		final int unionCnt = 30;
//		final int INCnt = 10;
//		int leftCnts = paramsList.size() % unionCnt;
//		int fullCnts = paramsList.size() / unionCnt;
//
//		int index = baseSql.indexOf("=");
//		String subSql = baseSql.substring(0 ,index);
//
//		for(int i=0;i<fullCnts;i++){
//	    	String sql = getInAggrSql(subSql,unionCnt,INCnt);
//	    	int start = i * unionCnt;
//	    	int end = (i+1)*unionCnt;
//	    	Object[] realParams = getAggrParams(paramsList.subList(start, end));
//	    	if(null == realParams){
//	    		continue;
//	    	}
//	    	SqlInfo sqlInfo = new SqlInfo(sql,realParams,null);
//	    	sqlInfoList.add(sqlInfo);
//	    }
//		//所有不足30的组合成一个union all语句
//
//		if(leftCnts >0 ){
//			String sql = getInAggrSql(subSql,leftCnts,INCnt);
//			paramsList = paramsList.subList((fullCnts*unionCnt),paramsList.size());
//	    	Object[] realParams = getAggrParams(paramsList);
//	    	if(null != realParams){
//	    	  SqlInfo sqlInfo = new SqlInfo(sql,realParams,null);
//	    	  sqlInfoList.add(sqlInfo);
//	    	}
//		}
//		return sqlInfoList;
//	}
//	public static String getInAggrSql(String sql,int count,int INCnt){
//		StringBuffer allSql = new StringBuffer();
//	    boolean bFirst = true;
//		while( 0!=count){
//			if(count / INCnt >0){
//				if(bFirst){
//					allSql.append(sql).append(" in (?,?,?,?,?)" );
//					bFirst = false;
//				}
//				else{
//					allSql.append(" union all ").append(sql).append(" in (?,?,?,?,?)" );
//				}
//				count = count -5;
//			}
//			else{
//				if(!bFirst){
//				   allSql.append(" union all ");
//				}
//				if( 1 == count){
//					allSql.append(sql).append(" =?");
//				}
//				else{
//				    allSql.append(sql).append(" in ( ");
//			    	for(int i=0;i<count;i++){
//				     if( 0 == i){
//						allSql.append(" ? ");
//					  }
//					 else{
//						allSql.append(",? ");
//				     }
//			    	}
//				    allSql.append(" ) ");
//				}
//				count = 0;
//			}
//		}
//		return allSql.toString();
//	}

    //==================聚合方式一：改为通过in来实现对象的加载，以避免通过union all方式产生临时表的问题

    public static List<SqlInfo> getInSql(List<Object[]> paramsList, final String baseSql, List<Type> returnTypes) {
        List<SqlInfo> sqlInfoList = new ArrayList<SqlInfo>();
        int leftCnts = paramsList.size() % IN_CNT;
        int fullCnts = paramsList.size() / IN_CNT;
        int index = baseSql.indexOf("=");
        String subSql = baseSql.substring(0, index);

        for (int i = 0; i < fullCnts; i++) {
            String sql = getInAggrSql(subSql,IN_CNT);
            int start = i * IN_CNT;
            int end = (i + 1) * IN_CNT;
            Object[] realParams = getAggrParams(paramsList.subList(start, end));
            if (null == realParams) {
                continue;
            }
            SqlInfo sqlInfo = new SqlInfo(sql, realParams, null);
            sqlInfoList.add(sqlInfo);
        }
        //所有不足30的组合成一个union all语句

        if (leftCnts > 0) {
            String sql =  getInAggrSql(subSql,leftCnts);
            paramsList = paramsList.subList((fullCnts * IN_CNT), paramsList.size());
            Object[] realParams = getAggrParams(paramsList);
            if (null != realParams) {
                SqlInfo sqlInfo = new SqlInfo(sql, realParams, null);
                sqlInfoList.add(sqlInfo);
            }
        }
        return sqlInfoList;
    }

	private static String getInAggrSql(String sql,int count){
		StringBuffer allSql = new StringBuffer();
        if(count == IN_CNT){
            allSql.append(sql).append(" in (?,?,?,?,?,?,?,?,?,?)");
        }
        else{
             allSql.append(sql).append(" in (");
            for(int i=0;i<count;i++){
                if(i >0 ){
                    allSql.append(",?");
                }
                else{
                    allSql.append("?");
                }
            }
            allSql.append(" ) ");
        }
        return allSql.toString();
	}


    //==================聚合方式二。通过union all 的方式生成相应的SQL

    public static List<SqlInfo> getUnionSql(List<Object[]> paramsList, final String baseSql, List<Type> returnTypes) {
        List<SqlInfo> sqlInfoList = new ArrayList<SqlInfo>();
        final int unionCnt = 30;
        int leftCnts = paramsList.size() % unionCnt;
        int fullCnts = paramsList.size() / unionCnt;

        for (int i = 0; i < fullCnts; i++) {
            String sql = getUnionAggrSql(baseSql, unionCnt);
            int start = i * unionCnt;
            int end = (i + 1) * unionCnt;
            Object[] realParams = getAggrParams(paramsList.subList(start, end));
            if (null == realParams) {
                continue;
            }
            SqlInfo sqlInfo = new SqlInfo(sql, realParams, null);
            sqlInfoList.add(sqlInfo);
        }
        //所有不足30的组合成一个union all语句

        if (leftCnts > 0) {
            String sql = getUnionAggrSql(baseSql, leftCnts);
            paramsList = paramsList.subList((fullCnts * unionCnt), paramsList.size());
            Object[] realParams = getAggrParams(paramsList);
            if (null != realParams) {
                SqlInfo sqlInfo = new SqlInfo(sql, realParams, null);
                sqlInfoList.add(sqlInfo);
            }
        }
        return sqlInfoList;
    }

    private static String getUnionAggrSql(String sql, int count) {
        StringBuffer allSql = new StringBuffer();
        for (int i = 0; i < count; i++) {
            if (i < count - 1) {
                allSql.append(sql).append(" union all ");
            } else {
                allSql.append(sql);
            }
        }
        return allSql.toString();
    }

    public static List<SqlInfo> getEntityUnionSql(List idList, final String baseSql) {
        List<SqlInfo> sqlInfoList = null;
        if (idList.size() > 0) {
            List<Object[]> paramsList = new ArrayList<Object[]>();
            for (Object id : idList) {
                if (null != id) {
                    paramsList.add(new Object[]{id});
                }
            }
            if (paramsList.size() > 0) {
//                return getInSql(paramsList,baseSql,null);
                return getUnionSql(paramsList, baseSql, null);
            }

        }
        return sqlInfoList;
    }


    public static Object[] getAggrParams(List<Object[]> paramsList) {
        List aggrList = new ArrayList();
        for (Object[] params : paramsList) {
            for (Object param : params) {
                if (null == param) {
                    return null;
                }
                aggrList.add(param);
            }
        }
        return aggrList.toArray();
    }


    public static void main(String[] args) {
        List newList = new ArrayList();
        for (int i = 21; i > 0; i--) {
            newList.add(new Object[]{1});
        }
        List<SqlInfo> sqlInfoList = getUnionSql(newList, "select * from tables where id =?", null);
        for (SqlInfo sqlIfo : sqlInfoList) {
            System.out.println(" =========Sql ========\r\n");
            System.out.println(sqlIfo.getSql());
        }
    }


    //
//	
    //正式上线时用的是这个数组
//	public static int[] numArray = new int[]{500,400,300,200,100,90,80,70,60,50,40,30,20,10,9,8,7,6,5,4,3,2,1};

//	 这是初次的思路，实际运行时是肯定不可能的
//	/**
//	 * 
//	 * @param paramsList
//	 * @param baseSql
//	 * @param returnTypes --- sql 语句查询结果的类型
//	 * @return
//	 */
//	public static List<SqlInfo> getUnionSql(List<Object[]> paramsList,final String baseSql,List<Type> returnTypes) {
//		List<SqlInfo> sqlInfoList= new ArrayList<SqlInfo>();
//		for(int keyNum : numArray){
//			int lestSize = paramsList.size() / keyNum;
//			if( 0 == lestSize){
//				continue;
//			}
//		    for(int i=0;i<lestSize;i++){
//		    	String sql = getAggrSql(baseSql, keyNum);
//		    	int start = i * keyNum;
//		    	int end = (i+1)*keyNum;
//		    	Object[] realParams = getAggrParams(paramsList.subList(start, end));
//		    	if(null == realParams){
//		    		continue;
//		    	}
//		    	SqlInfo sqlInfo = new SqlInfo(sql,realParams,null);
//		    	sqlInfoList.add(sqlInfo);
//		    }
//		    if(keyNum == paramsList.size() ){
//		    	break;
//		    }
//		    paramsList = paramsList.subList((keyNum-1),paramsList.size()-1);
//		}
//		return sqlInfoList;
//	}	

}
