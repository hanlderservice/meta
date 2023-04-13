package com.chenyu.meta.quartz.service;

import com.chenyu.meta.quartz.entity.JobAndTrigger;
import com.chenyu.meta.quartz.mapper.ScheduleJobMapper;
import com.chenyu.meta.quartz.util.ScheduleUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Configuration
@EnableScheduling
@Component
public class ScheduleRefreshService {

    private Logger logger = LoggerFactory.getLogger(ScheduleRefreshService.class);

    @Resource(name = "jobDetail")
    private JobDetail jobDetail;

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    @Autowired
    private ScheduleJobMapper jobMapper;


    @Scheduled(fixedRate = 5000)
    public void scheduleCronTrigger() throws SchedulerException {

//        logger.info(">>>>>>>>>>>>>>每隔5秒查询一次数据库....");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("isDurable", "1");
        List<JobAndTrigger> jobAndTriggers = jobMapper.qryJobList(paramMap);
//        logger.info(">>>>>>>>>>>>>>"+jobAndTriggers.toString());
        if (CollectionUtils.isEmpty(jobAndTriggers)) {
            return;
        }


        for (JobAndTrigger jobAndTrigger : jobAndTriggers) {
            CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler, jobAndTrigger.getJobName(), jobAndTrigger.getJobGroup());
            if (null == cronTrigger) {
                //创建一个
                ScheduleUtil.createScheduleJob(scheduler, jobAndTrigger);
            } else {
                //已存在，那么更新相应的定时设置
                ScheduleUtil.updateScheduleJob(scheduler, jobAndTrigger);
            }

        }


    }


}
