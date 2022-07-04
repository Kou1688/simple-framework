package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * 判断工具类
 *
 * @author KouChaoJie
 * @since: 2022/7/4 14:01
 */
public class ValidationUtil {
    /**
     * 集合是否为空
     *
     * @param obj 集合
     * @return true:为空 false:不为空
     */
    public static boolean isEmpty(Collection<?> obj) {
        return obj.size() == 0;
    }

    /**
     * 字符串是否为空
     *
     * @param obj string
     * @return true:为空 false:不为空
     */
    public static boolean isEmpty(String obj) {
        return obj == null || "".equals(obj);
    }

    /**
     * Array是否为null或者size为0
     *
     * @param obj Array
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

    /**
     * Map是否为null或size为0
     *
     * @param obj Map
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> obj) {
        return obj == null || obj.isEmpty();
    }
}
