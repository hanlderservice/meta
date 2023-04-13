package com.chenyu.meta.common.util;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class BeanMapUtil {


    public static final Logger LOGGER = LoggerFactory.getLogger(BeanMapUtil.class);

    /**
     * 将JavaBean对象转换成Map集合
     *
     * @param bean
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Map<String, Object> bean2Map(T bean) {
        Map<String, Object> map = null;
        try {
            map = new HashMap<>();
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : list) {
                String key = pd.getName();//获取属性名
                Object value = pd.getReadMethod().invoke(bean);//调用getter()方法,获取内容
                if (ObjectUtils.isNotEmpty(value)) {
                    map.put(key, value);//增加到map集合当中
                } else {
                    map.put(key, "");//增加到map集合当中

                }
            }
        } catch (Exception e) {
            LOGGER.error(">>>>>>>>>>>>>>", e);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map转JavaBean对象
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) throws Exception {
        //采用反射动态创建对象
        T obj = clazz.newInstance();
        //获取对象字节码信息,不要Object的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        //获取bean对象中的所有属性
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : list) {
            String key = pd.getName();    //获取属性名
            Object value = map.get(key);  //获取属性值
            pd.getWriteMethod().invoke(obj, value);//调用属性setter()方法,设置到javabean对象当中
        }
        return obj;

    }



}
