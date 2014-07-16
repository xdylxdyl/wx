package com.qding.common.pay.uitl.ll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
* 常用工具函数
* @author guoyx e-mail:guoyx@lianlian.com
* @date:2013-6-25 下午05:23:05
* @version :1.0
*
*/
public class YinTongUtil{
    /**
     * str空判断
     * @param str
     * @return
     */
    public static boolean isnull(String str)
    {
        if (null == str || str.equalsIgnoreCase("null") || str.equals(""))
        {
            return true;
        } else
            return false;
    }

    /**
     * 获取当前时间str，格式yyyyMMddHHmmss
     * @return
     */
    public static String getCurrentDateTimeStr()
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String timeString = dataFormat.format(date);
        return timeString;
    }


    /**
     * 生成待签名串
     * @param paramMap
     * @return
     */
    public static String genSignData(JSONObject jsonObject)
    {
        StringBuffer content = new StringBuffer();

        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < keys.size(); i++)
        {
            String key = (String) keys.get(i);
            if ("sign".equals(key))
            {
                continue;
            }
            String value = jsonObject.getString(key);
          //空串不参与签名
            if (isnull(value))
            {
                continue;
            }
            content.append((i == 0 ? "" : "&") + key + "=" + value);

        }
        String signSrc = content.toString();
        if(signSrc.startsWith("&")){
            signSrc = signSrc.replaceFirst("&", "");
        }
        return signSrc;
    }
}
