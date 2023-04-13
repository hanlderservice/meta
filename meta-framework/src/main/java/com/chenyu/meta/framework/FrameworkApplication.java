package com.chenyu.meta.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@SpringBootApplication
public class FrameworkApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrameworkApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class, args);

        LOGGER.info(">>>>>>>>>>>启动成功！>>>>>>>>>");
    }


}
