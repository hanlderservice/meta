package com.chenyu.meta.system.controller;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.param.SysUmsUserListParam;
import com.chenyu.meta.system.param.SysUmsUserParam;
import com.chenyu.meta.system.service.UmsSysUserService;
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
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@RestController
@RequestMapping("/sysUmsApi")
@Api(value = "系统用户管理API", tags = {"系统用户管理"})
public class UmsSysUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UmsSysUserService umsSysUserService;

    @Log("用户管理列表查询")
    @PostMapping("/qrySysUmsUserList")
    @ApiOperation(value = "用户管理列表查询", notes = "系统用户管理列表查询")
    public ApiResult qrySysUmsUserList(@Validated @RequestBody SysUmsUserListParam umsUserParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>用户管理列表查询请求参数>>>>>>>>>>>umsUserParam:{}", umsUserParam);
        return umsSysUserService.qrySysUmsUserList(umsUserParam);
    }

    @Log("添加系统用户")
    @PostMapping("/saveSysUmsUser")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public ApiResult saveSysUmsUser(@Validated @RequestBody SysUmsUserParam umsUserParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>添加系统用户-->请求参数>>>>>>>>>>>umsUserParam:{}", umsUserParam);
        return umsSysUserService.saveSysUmsUser(umsUserParam);
    }

    @Log("删除系统用户")
    @PostMapping("/delSysUmsUser")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public ApiResult delSysUmsUser(@Validated @RequestBody SysUmsUserParam umsUserParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>删除系统用户-->请求参数>>>>>>>>>>>umsUserParam:{}", umsUserParam);
        return umsSysUserService.delSysUmsUser(umsUserParam);
    }

    @Log("修改系统用户")
    @PostMapping("/updateSysUmsUser")
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public ApiResult updateSysUmsUser(@Validated @RequestBody SysUmsUserParam umsUserParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>修改系统用户-->请求参数>>>>>>>>>>>umsUserParam:{}", umsUserParam);
        return umsSysUserService.updateSysUmsUser(umsUserParam);
    }



}
