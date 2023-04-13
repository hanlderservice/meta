package com.chenyu.meta.quartz.service.impl;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.quartz.base.BaseJob;
import com.chenyu.meta.quartz.entity.JobAndTrigger;
import com.chenyu.meta.quartz.mapper.ScheduleJobMapper;
import com.chenyu.meta.quartz.service.ScheduleJobService;
import com.chenyu.meta.quartz.util.JobUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @Autowired
    private Scheduler scheduler;


    @Override
    public List<JobAndTrigger> queryScheduleJobList(Map<String, Object> pageParam) {

        return scheduleJobMapper.qryJobList(pageParam);

    }

    @Override
    public List<JobAndTrigger> queryExecutingJobList() {
        List<JobAndTrigger> jobList = new ArrayList<>();

        try {
            //获取scheduler中的JobGroupName
            for (String group : scheduler.getJobGroupNames()) {
//                获取JobKey 循环遍历JobKey
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.groupEquals(group))) {
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    JobDataMap jobDataMap = jobDetail.getJobDataMap();
                    JobAndTrigger jobAndTrigger = (JobAndTrigger) jobDataMap.get("jobParam");
                    if (jobAndTrigger != null)
                        jobList.add(jobAndTrigger);
                }
            }
        } catch (SchedulerException e) {
            logger.error("获取正在运行的任务列表失败！" + e.getMessage());
            e.printStackTrace();
        }
        logger.info(">>>>>>>>>>>>>>>获取正在运行的任务列表..." + jobList);

        return jobList;
    }

    @Override
    public ApiResult addJob(Map<String, Object> jobForm) {

        try {
            String jobClassName = MapUtils.getString(jobForm, "jobClassName");
            String jobGroupName = MapUtils.getString(jobForm, "jobGroupName");
            String cronExpression = MapUtils.getString(jobForm, "cronExpression");

            Class<? extends BaseJob> aClass = JobUtil.getClass(jobClassName).getClass();

            //先查询任务是否存在
            Map<String, Object> params = new HashMap<>();
            params.put("jobName", aClass.getSimpleName());
            List<JobAndTrigger> jobAndTriggers = scheduleJobMapper.qryJobList(params);
            if (CollectionUtils.isEmpty(jobAndTriggers)) {
                addScheduledJob(aClass.getSimpleName(), jobForm);
            } else {
                cronScheduledJob(aClass.getSimpleName(), jobForm);
            }

            //启动调度器
            scheduler.start();
            //构建Job信息
            JobDetail jobDetail = JobBuilder.newJob(aClass)
                    .withIdentity(jobClassName, jobGroupName).build();
            //Cron表达式调度构建起(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            //根据Cron表达式构建一个Trigger
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobClassName, jobGroupName)
                    .withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
            return ApiResult.ok("添加成功!");
        } catch (Exception e) {
            logger.error("【定时任务】创建失败！", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务创建失败：" + e.getMessage());
        }

    }


    @Override
    public ApiResult deleteJob(Map<String, Object> jobForm) {
        String jobClassName = MapUtils.getString(jobForm, "jobClassName");
        String jobGroupName = MapUtils.getString(jobForm, "jobGroupName");
        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
            scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
            Class<? extends BaseJob> aClass = JobUtil.getClass(jobClassName).getClass();
            jobForm.put("isDurable", "0");
            cronScheduledJob(aClass.getSimpleName(), jobForm);
            return ApiResult.ok("定时任务删除成功");
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>【定时任务】 删除任务失败！", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务删除失败" + e.getMessage());
        }
    }

    @Override
    public ApiResult pauseJob(Map<String, Object> jobForm) {
        String jobClassName = MapUtils.getString(jobForm, "jobClassName");
        String jobGroupName = MapUtils.getString(jobForm, "jobGroupName");
        try {
            scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
            return ApiResult.ok("操作成功");
        } catch (SchedulerException e) {
            logger.error(">>>>>>>>>>>>>>>>>>【定时任务】 失败", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务操作失败：" + e.getMessage());
        }
    }

    @Override
    public ApiResult resumeJob(Map<String, Object> jobForm) {
        String jobClassName = MapUtils.getString(jobForm, "jobClassName");
        String jobGroupName = MapUtils.getString(jobForm, "jobGroupName");
        try {
            scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
            return ApiResult.ok("定时任务操作成功!");
        } catch (SchedulerException e) {
            logger.error(">>>>>>>>>>>>>>>【定时任务】,", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务操作失败!:" + e.getMessage());
        }

    }

    @Override
    public ApiResult cronJob(Map<String, Object> jobForm) {
        String jobClassName = MapUtils.getString(jobForm, "jobClassName");
        String jobGroupName = MapUtils.getString(jobForm, "jobGroupName");
        String cronExpression = MapUtils.getString(jobForm, "cronExpression");
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //根据cron表达式构建一个Trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            scheduler.rescheduleJob(triggerKey, trigger);
            Class<? extends BaseJob> aClass = JobUtil.getClass(jobClassName).getClass();
            cronScheduledJob(aClass.getSimpleName(), jobForm);
            return ApiResult.ok("定时任务更新成功!");
        } catch (SchedulerException e) {
            logger.error("【定时任务】更新失败！", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务更新失败" + e.getMessage());

        } catch (Exception e) {
            logger.error("【定时任务】更新失败！", e);
            e.printStackTrace();
            return ApiResult.fail("定时任务更新失败" + e.getMessage());

        }

    }

    /**
     * 修改定时任务
     *
     * @param simpleName
     * @param jobForm
     */
    private void cronScheduledJob(String simpleName, Map<String, Object> jobForm) {


        List<JobAndTrigger> jobAndTriggers = scheduleJobMapper.qryJobList(jobForm);
        logger.info(jobAndTriggers.toString());
        if (CollectionUtils.isNotEmpty(jobAndTriggers)) {
            Long scheduleJobId = jobAndTriggers.get(0).getScheduleJobId();
            jobForm.put("jobId", scheduleJobId + "");
            scheduleJobMapper.updateScheduleJob(jobForm);
        }


    }

    /**
     * 添加定时任务
     *
     * @param simpleName
     * @param jobForm
     */
    private void addScheduledJob(String simpleName, Map<String, Object> jobForm) {


        scheduleJobMapper.addScheduleJob(jobForm);


    }


}
