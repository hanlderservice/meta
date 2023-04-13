package com.chenyu.meta.quartz.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.quartz.entity.JobAndTrigger;
import com.chenyu.meta.quartz.params.CronTaskParam;
import com.chenyu.meta.quartz.params.ScheduleJobParam;
import com.chenyu.meta.quartz.service.ScheduleJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@RestController
@RequestMapping("/scheduledJobApi")
@Api(value = "定时任务API", tags = {"定时任务"})
public class ScheduleJobController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Log("定时任务查询")
    @PostMapping("/listScheduleJob")
    @ApiOperation(value = "查询定时任务", notes = "查询定时任务")
    public ApiResult listScheduleJob(@RequestBody ScheduleJobParam pageParam) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);
        List<JobAndTrigger> jobAndTriggers = scheduleJobService.queryScheduleJobList(paramsMap);

        resultMap.put("scheduleJobList", JSON.toJSON(jobAndTriggers));
        //获取正在运行的任务列表
        List<JobAndTrigger> executingJobList = scheduleJobService.queryExecutingJobList();
        resultMap.put("executingJobList", JSON.toJSON(executingJobList));

        return ApiResult.ok(resultMap);
    }

    @Log("添加定时任务")
    @PostMapping("/addScheduleJob")
    @ApiOperation(value = "添加定时任务", notes = "添加定时任务")
    public ApiResult addScheduleJob(@RequestBody CronTaskParam pageParam) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);

        return scheduleJobService.addJob(paramsMap);
    }

    @Log("重新配置定时任务")
    @PostMapping("/cronScheduleJob")
    @ApiOperation(value = "重新配置定时任务", notes = "重新配置定时任务")
    public ApiResult updateScheduleJob(@RequestBody CronTaskParam pageParam) {

        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);
        logger.info(">>>>>>>>>>>>>>>重新配置定时任务：请求参数:" + paramsMap);
        return scheduleJobService.cronJob(paramsMap);
    }

    @Log("删除定时任务")
    @PostMapping("/delScheduleJob")
    @ApiOperation(value = "删除定时任务", notes = "删除定时任务")
    public ApiResult delScheduleJob(@RequestBody CronTaskParam pageParam) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);
        logger.info(">>>>>>>>>>>>>>>delScheduleJob：请求参数:" + paramsMap);
        return scheduleJobService.deleteJob(paramsMap);
    }

    @Log("暂停定时任务")
    @PostMapping("/pauseScheduleJob")
    @ApiOperation(value = "暂停定时任务", notes = "暂停定时任务")
    public ApiResult pauseScheduleJob(@RequestBody CronTaskParam pageParam) {

        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);
        logger.info(">>>>>>>>>>>>>>>pauseScheduleJob：请求参数:" + paramsMap);
        return scheduleJobService.pauseJob(paramsMap);
    }

    @Log("恢复定时任务")
    @PostMapping("/resumeScheduleJob")
    @ApiOperation(value = "恢复定时任务", notes = "恢复定时任务")
    public ApiResult resumeScheduleJob(@RequestBody CronTaskParam pageParam) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(pageParam);
        logger.info(">>>>>>>>>>>>>>>resumeScheduleJob：请求参数:" + paramsMap);
        return scheduleJobService.resumeJob(paramsMap);
    }



}
