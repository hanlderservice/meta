package com.chenyu.meta.quartz.config;

import com.chenyu.meta.quartz.task.ScheduledTask;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Configuration
public class QuartzTaskConfig {

    private Logger logger = LoggerFactory.getLogger(QuartzTaskConfig.class);

    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTask task) {
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        /**
         * 是否并发执行
         *
         */
        jobDetailFactoryBean.setConcurrent(false);
        //设置定时任务的名字
        jobDetailFactoryBean.setName("MetaScheduler");
        //设置任务的分组，这些属性都可以再数据库中，再多任务的时候使用
        //为需要执行的实体类对应的对象
        jobDetailFactoryBean.setTargetObject(task);
        jobDetailFactoryBean.setTargetMethod("init");
        logger.info("jobDetailFactoryBean 初始化成功！");
        return jobDetailFactoryBean;

    }

    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail.getObject());
        factoryBean.setCronExpression("1/5 * * * * ?");
        factoryBean.setName("MetaScheduler");
        logger.info("Job Trigger 初始化成功!");
        return factoryBean;
    }

    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger trigger) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        //用于quartz集群，QuartzScheduler启动时更新已存在的job
        factoryBean.setOverwriteExistingJobs(true);
        //延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);
        //注册触发器
        factoryBean.setTriggers(trigger);
//        factoryBean.setTaskExecutor(th);


        logger.info("scheduler 初始化成功！");
        return factoryBean;
    }





}
