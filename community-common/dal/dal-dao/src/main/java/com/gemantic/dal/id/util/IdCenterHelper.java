package com.gemantic.dal.id.util;

/**
 * @author arthurkang
 */

import com.gemantic.dal.config.helper.DaoHelper;

public class IdCenterHelper {

    // 数据库中存放 sequence 的表名
    private static final String SeqTableName = "dalSequence";
    // 用户在POJO 的类文件中制定所使用sequence,所用的参数
    private static final String SeqParamName = "sequence";
    private static final String IdCenterDatasourceName = DaoHelper.getIdCenterDsName();


    public static String getTableName() {
        return SeqTableName;
    }

    public static String getSeqParamName() {
        return SeqParamName;
    }

    public static String getIDCenterDataSourceName() {
        return IdCenterDatasourceName;
    }

}
