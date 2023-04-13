package com.chenyu.meta.quartz.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.quartz.entity.JobAndTrigger;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface ScheduleJobService {
    /**
     * 获取定时任务列表
     *
     * @param pageParam
     * @return
     */
    List<JobAndTrigger> queryScheduleJobList(Map<String, Object> pageParam);

    /**
     * 获取运行中的job列表
     *
     * @return
     */
    List<JobAndTrigger> queryExecutingJobList();


    /**
     * 添加并启动定时任务
     *
     * @param jobForm 表单参数
     */
    ApiResult addJob(Map<String, Object> jobForm);

    /**
     * 删除定时任务
     *
     * @param jobForm 表单参数
     */
    ApiResult deleteJob(Map<String, Object> jobForm);

    /**
     * 暂停定时任务
     *
     * @param jobForm 表单参数
     */
    ApiResult pauseJob(Map<String, Object> jobForm);

    /**
     * 恢复定时任务
     *
     * @param jobForm 表单参数
     */
    ApiResult resumeJob(Map<String, Object> jobForm);

    /**
     * 重新配置定时任务
     *
     * @param jobForm 表单参数
     */
    ApiResult cronJob(Map<String, Object> jobForm);




}
