package com.hxoim.common.rmbKit;

import com.hxoim.common.rmbKit.models.RmTable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassConvertHelper {
	
    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("xingMing", "张三");
        map1.put("xingBie", "男");
        map1.put("minZu", "汉族");
        map1.put("jiGuan", "陕西西安");

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("xingMing", "王五");
        map2.put("xingBie", "男");
        map2.put("minZu", "回族");
        map2.put("jiGuan", "海南海口");
        mapList.add(map1);
        mapList.add(map2);

        RmTable rmb = (RmTable) map2Object(map1, RmTable.class);
        System.out.println(rmb.getMinZu());
        //ListObject强制转换为ListT
        Object rmbList = (Object) mapList2ObjectList(mapList, RmTable.class);
        List<RmTable> rmbList1 = (List<RmTable>) rmbList;
        if (rmbList1 != null && rmbList1.size() > 0) {
            for (RmTable rmTable : rmbList1) {
                System.out.println(rmTable.getXingMing());
            }
        }
    }

    /****
     * Map转为自定义对象
     * @param map
     * @param clazz
     * @return
     */
    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                String fieldName = field.getName();
                if (!Character.isLowerCase(fieldName.charAt(0)))
                    fieldName = (new StringBuilder()).append(Character.toLowerCase(fieldName.charAt(0))).append(fieldName.substring(1)).toString();
                System.out.println(fieldName);

                Object fieldValue = map.get(fieldName);
                field.setAccessible(true);
                if (fieldValue!=null&&field.getType().toString().equals("class java.lang.String") && !fieldValue.getClass().getName().equals("class java.lang.String")) {
                    field.set(obj, fieldValue == null ? "" : fieldValue.toString());
                } else if (fieldValue!=null&&field.getType().toString().equals("java.math.BigDecimal") && !fieldValue.getClass().getName().equals("java.math.BigDecimal")) {
                    field.set(obj, fieldValue == null ? null : Integer.parseInt(fieldValue.toString()));
                } else {
                    field.set(obj, map.get(fieldName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /****
     * 将map对象List 转为自定义对象List
     * @param mapList
     * @param clazz
     * @return
     */
    public static List<Object> mapList2ObjectList(List<Map<String, Object>> mapList, Class<?> clazz) {
        List<Object> objList = new ArrayList<Object>();
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> map : mapList) {
                Object obj = map2Object(map, clazz);
                objList.add(obj);
            }
        }
        return objList;
    }
}
