package com.chenyu.meta.framework.controller;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.framework.param.LoginLogInfoParam;
import com.chenyu.meta.framework.param.OperaLogInfoParam;
import com.chenyu.meta.framework.service.SysLoginLogService;
import com.chenyu.meta.framework.service.SysOperationLogService;
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

import javax.servlet.http.HttpServletResponse;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 系统日志API
 */
@RestController
@RequestMapping("/systemLogApi")
@Api(value = "系统日志API", tags = {"系统日志"})
public class SysLogManageController {


    private Logger logger = LoggerFactory.getLogger(SysLogManageController.class);

    @Autowired
    private SysLoginLogService sysLoginLogService;
    @Autowired
    private SysOperationLogService operationLogService;

    @Log("系统登录日志")
    @PostMapping("/getLoginLogInfo")
    @ApiOperation(value = "登录日志", notes = "系统登录日志")
    public ApiResult getLoginLogInfo(@Validated @RequestBody LoginLogInfoParam params, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>系统登录日志管理请求参数>>>>>>>>>>>loginLogInfoParam:{}", params);


        return sysLoginLogService.getSysLoginLogPageList(params);
    }

    @Log("系统操作日志")
    @PostMapping("/getOperaLogInfo")
    @ApiOperation(value = "系统操作日志", notes = "系统操作日志")
    public ApiResult getOperaLogInfo(@Validated @RequestBody OperaLogInfoParam params, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>系统操作日志管理请求参数>>>>>>>>>>>loginLogInfoParam:{}", params);

        return operationLogService.getSysOperationLogPageList(params);
    }


}
