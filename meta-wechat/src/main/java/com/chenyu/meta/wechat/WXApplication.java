package com.chenyu.meta.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WXApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(WXApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(WXApplication.class, args);

        LOGGER.info(">>>>>>>>>>>启动成功！>>>>>>>>>");
    }

}
