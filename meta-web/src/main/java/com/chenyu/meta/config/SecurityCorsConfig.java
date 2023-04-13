package com.chenyu.meta.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

/**
 * Create by 10296 on 2023/2/27
 *
 * @Description:
 */
@Configuration
public class SecurityCorsConfig {


    @Bean
    public FilterRegistrationBean corsFilter() {

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //跨域配置

        corsConfiguration.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setMaxAge(1800L);

        configurationSource.registerCorsConfiguration("/**", corsConfiguration);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(configurationSource));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);


        return bean;

    }

}
