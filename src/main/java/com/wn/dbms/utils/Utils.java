package com.wn.dbms.utils;

import java.util.*;

public class Utils {

    /**
     * 判断对象是否为空
     * @param o 需要判断的对象
     * @return 为空返回true, 不为空返回false
     */
    public static boolean isEmpty(Object o) {
        if (o == null || Objects.isNull(o)) {
            return true;
        }
        if (o instanceof String) {
            if ("".equals(o.toString().trim())) {
                return true;
            }
            return "undefined".equals(o.toString().trim());
        } else if (o instanceof List) {
            return ((List) o).size() == 0;
        } else if (o instanceof Map) {
            return ((Map) o).size() == 0;
        } else if (o instanceof Set) {
            return ((Set) o).size() == 0;
        } else if (o instanceof Object[]) {
            return ((Object[]) o).length == 0;
        } else if (o instanceof int[]) {
            return ((int[]) o).length == 0;
        } else if (o instanceof long[]) {
            return ((long[]) o).length == 0;
        }
        return false;
    }


    /**
     * 检索出List中重复元素的下标
     * @param list
     * @return
     */
    public static List<Integer> findListRepeat(List<Integer> list){
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                index.add(i);
            }
        }

        return index;
    }
}
