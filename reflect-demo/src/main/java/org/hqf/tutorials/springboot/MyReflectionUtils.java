package org.hqf.tutorials.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
public class MyReflectionUtils {

    private static String AND = " AND ";

    public static <T> String buildWhereClause(final List<T> objList,
                                              final List<String> properties,
                                              final Map<String, String> propertyToColumnMap) {
        if (objList.isEmpty()) {
            return ""; // 如果列表为空，则返回空的 WHERE 子句
        }

        T firstObj = objList.get(0);
        Class<?> userClass = firstObj.getClass();

        StringBuilder whereClause = new StringBuilder();
        boolean isFirstUser = true;
        try {
            for (T obj : objList) {
                StringBuilder objectClause = new StringBuilder();
                ReflectionUtils.doWithFields(userClass, field -> {
                            field.setAccessible(true);
                            String fieldName = field.getName();
                            if (properties.contains(fieldName)) {

                                Object value = field.get(obj);

                               if(field.getType().equals(String.class)||field.getType().equals(Date.class)) {
                                   objectClause.append(propertyToColumnMap.get(fieldName)).append(" = '").append(value).append("' ");
                               }else {
                                   objectClause.append(propertyToColumnMap.get(fieldName)).append(" = ").append(value);
                               }
                            }
                        }
                );

                if (objectClause.length() > 0) {
                    if (!isFirstUser) {
                        whereClause.append(" OR ");
                    }
                    whereClause.append("(").append(objectClause).append(")");
                    isFirstUser = false;
                }
            }
        } catch (Exception e) {
            log.error("buildWhereClause error:{}", e.getMessage(), e);
            throw e;
        }
        return whereClause.toString();
    }
}
