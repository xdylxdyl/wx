package com.gemantic.dal.dao.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 用来解析一些标注的内容
 * 
 * @author cctv
 *
 */
public class AnnotationUtil {
private static final Log log = LogFactory.getLog(AnnotationUtil.class);

	/**
	 * 根据类的Class获取实体对应数据库的表名字
	 * @param clazz
	 * @return
	 */
	public static String getTableNameFromEntity(Class clazz){
		if(clazz != null){
		  Table table = (Table) clazz.getAnnotation(Table.class);
			if(null != table){
				return table.name();
			}
		}
		return null;
	}
	/**
	 * 
	 * 从方法和字段上的注解搜索id对应的数据库的列名
	 * 
	 * @param clazz 实体类的class
	 * @return id 字段对应的 数据库的列名
	 */
	public static String getIdClumnFromEntity(Class clazz){
		Method[] methods =clazz.getMethods();
		for(Method method : methods ){
			if( null != method.getAnnotation(Id.class)){
				Column column = method.getAnnotation(Column.class);
				if(null !=column ){
					return column.name();
				}else{
					String temp = method.getName().replaceAll("get", "");
					if(null != temp && !"".equals(temp.trim())){
						return WordUtils.uncapitalize(temp);
					}else{
						return null;
					}
				}
			}
		}
		
	   Field [] fields = clazz.getDeclaredFields();
	   for(Field field : fields){
		     if( null != field.getAnnotation(Id.class)){
				 Column column = field.getAnnotation(Column.class);
				 if(null !=column ){
					  return column.name();
					}else{
					  return field.getName();
					}
				}
			}
		
		return null;
	}
}
