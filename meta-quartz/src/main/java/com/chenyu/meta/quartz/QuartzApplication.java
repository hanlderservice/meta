package com.chenyu.meta.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(QuartzApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);

        LOGGER.info(">>>>>>>>>>>启动成功！>>>>>>>>>");
    }

}
