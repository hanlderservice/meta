package com.chenyu.meta.system.controller;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.param.SiteConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@RestController
@RequestMapping("/sysSiteConfigApi")
@Api(value = "系统公共配置API", tags = {"系统公共配置API"})
public class SiteConfigController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Log("站点配置")
    @PostMapping("/siteConfig")
    @ApiOperation(value = "站点配置", notes = "站点配置")
    public ApiResult siteConfig(@Validated @RequestBody SiteConfigParam siteConfigParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>站点配置请求参数>>>>>>>>>>>loginParam:{}", siteConfigParam);
        return ApiResult.ok(siteConfigParam);
    }


}
