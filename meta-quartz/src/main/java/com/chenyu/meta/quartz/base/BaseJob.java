package com.chenyu.meta.quartz.base;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description: Job基类 主要是在Job上在封装一层
 */
public interface BaseJob  extends Job {

    /**
     * 定时任务
     *
     * @param jobExecutionContext 上下文
     * @throws JobExecutionException e
     */
    @Override
    void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;

}
