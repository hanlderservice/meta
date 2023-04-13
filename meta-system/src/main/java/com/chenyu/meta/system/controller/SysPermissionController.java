package com.chenyu.meta.system.controller;

import com.chenyu.meta.common.param.BasePageParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.service.SysPermissionService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description: 系统权限控制
 */
@RestController
@RequestMapping("/sysPermissionApi")
@Api(value = "系统权限API", tags = {"系统权限API"})
public class SysPermissionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SysPermissionService sysPermissionService;


    @Log("获取路由信息")
    @PostMapping("/getRouters")
    @ApiOperation(value = "查询路由信息", notes = "查询路由信息")
    public ApiResult getRouters(@Validated @RequestBody BasePageParam baseParam, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        logger.info(">>>>>>>>>>>>" + baseParam.toString());
        return sysPermissionService.queryPermissionMenus(baseParam);
    }

    @Log("系统菜单")
    @PostMapping("/queryMenuList")
    @ApiOperation(value = "查询系统菜单列表", notes = "查询系统菜单列表")
    public ApiResult queryMenuList(@Validated @RequestBody BasePageParam baseParam, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        logger.info(">>>>>>>>>>>>" + baseParam.toString());
        return sysPermissionService.queryPermissionMenus(baseParam);
    }

    @Log("添加系统菜单")
    @PostMapping("/addPermissionMenu")
    @ApiOperation(value = "添加系统菜单", notes = "添加系统菜单")
    public ApiResult addPermissionMenu(@Validated @RequestBody BasePageParam baseParam, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        logger.info(">>>>>>>>>>>>" + baseParam.toString());
        return sysPermissionService.queryPermissionMenus(baseParam);
    }

    @Log("修改系统菜单")
    @PostMapping("/updatePermissionMenu")
    @ApiOperation(value = "修改系统菜单", notes = "修改系统菜单")
    public ApiResult updatePermissionMenu(@Validated @RequestBody BasePageParam baseParam, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        logger.info(">>>>>>>>>>>>" + baseParam.toString());
        return sysPermissionService.queryPermissionMenus(baseParam);
    }

    @Log("删除系统菜单")
    @PostMapping("/delPermissionMenu")
    @ApiOperation(value = "删除系统菜单", notes = "删除系统菜单")
    public ApiResult delPermissionMenu(@Validated @RequestBody BasePageParam baseParam, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        logger.info(">>>>>>>>>>>>" + baseParam.toString());
        return sysPermissionService.queryPermissionMenus(baseParam);
    }


}
