package com.chenyu.meta.quartz.util;

import com.chenyu.meta.quartz.base.BaseJob;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description: 定时任务反射工具
 */
public class JobUtil {

    public static BaseJob getClass(String className) throws Exception {

        Class<?> aClass = Class.forName(className);
        return (BaseJob) aClass.newInstance();

    }


}
