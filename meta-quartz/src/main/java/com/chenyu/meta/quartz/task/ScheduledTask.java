package com.chenyu.meta.quartz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Configuration
@Component
@EnableScheduling
public class ScheduledTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public void init() {
//        logger.info(">>>>>>>>>定时任务初始化>>>>>>>>>>>>>>>.");
    }

    public void scheduleUpdateCronTrigger() {

    }
}
