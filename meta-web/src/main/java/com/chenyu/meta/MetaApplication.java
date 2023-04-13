package com.chenyu.meta;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableConfigurationProperties
@ServletComponentScan
@MapperScan({"com.chenyu.meta.**.mapper"})
@SpringBootApplication
public class MetaApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(MetaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MetaApplication.class, args);

        LOGGER.info(">>>>>>>>>>>启动成功！>>>>>>>>>");

    }

}
