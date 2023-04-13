package com.chenyu.meta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);

        LOGGER.info(">>>>>>>>>>>启动成功！>>>>>>>>>");
    }

}
