package com.chenyu.meta.system.controller;

import com.alibaba.fastjson2.JSON;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.config.properties.LogAopProperties;
import com.chenyu.meta.config.properties.MetaProperties;
import com.chenyu.meta.config.properties.ShiroProperties;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.param.LoginParam;
import com.chenyu.meta.system.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
@RestController
@RequestMapping("/systemApi")
@Api(value = "系统登录API", tags = {"系统登录"})
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;


    @Autowired
    private MetaProperties metaProperties;
    @Autowired
    private ShiroProperties shiroProperties;
    @Autowired
    private LogAopProperties logAopProperties;
    @Autowired
    private JwtProperties jwtProperties;


    @Log("系统登录")
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "系统用户登录")
    public ApiResult login(@Validated @RequestBody LoginParam loginParam, HttpServletResponse response) {

        return loginService.login(loginParam, response);
    }

    @Log("获取登录用户信息")
    @PostMapping("/getUserInfo")
    @ApiOperation(value = "获取用户登录信息", notes = "获取用户登录信息")
    public ApiResult getUserInfo(HttpServletRequest request, @Validated @RequestBody BaseParam param, HttpServletResponse response) {

        return loginService.getUserInfo(request, param, response);
    }











}
