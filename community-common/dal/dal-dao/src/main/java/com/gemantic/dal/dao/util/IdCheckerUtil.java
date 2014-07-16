package com.gemantic.dal.dao.util;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class IdCheckerUtil {
  //logger
  private static final Logger logger = Logger.getLogger(IdCheckerUtil.class);

  //max id container
  private static Map maxIds = new ConcurrentHashMap();


  public static void newObjectSaved(Class clazz, Object id) {
    if (clazz != null && id != null && id instanceof Long) {
      synchronized (clazz) {
        String key = clazz.getName();
        Long oldId = (Long) maxIds.get(key);
        Long newId = (Long) id;
        if (oldId == null || oldId.longValue() < newId.longValue()) {
          maxIds.put(key, id);
        }
      }
    }
  }

  public static boolean isIdValid(Class clazz, Object id) {
    boolean valid = true;
    if (clazz != null && id != null && id instanceof Long) {
      String key = clazz.getName();
      Long maxId = (Long) maxIds.get(key);
      if (maxId != null) {
        long maxValue = maxId.longValue();
        long newIdValue = ( (Long) id).longValue();
        if (newIdValue > maxValue) {
          //invalid id, id value exceeds the max id's value
          valid = false;
        }
      }
    }
    return valid;
  }

}
