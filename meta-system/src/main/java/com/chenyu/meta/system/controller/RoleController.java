package com.chenyu.meta.system.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.param.BasePageParam;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.domain.SysRole;
import com.chenyu.meta.system.param.SysRoleParam;
import com.chenyu.meta.system.service.SysRoleService;
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
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@RestController
@RequestMapping("/systemRoleApi")
@Api(value = "系统角色管理API", tags = {"系统角色管理API"})
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysRoleService sysRoleService;


    @Log("查询角色列表")
    @PostMapping("/qryRoleList")
    @ApiOperation(value = "角色列表", notes = "角色列表")
    public ApiResult qrySysRoleList(@Validated @RequestBody BasePageParam pageParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>角色列表>>>>>" + pageParam);
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", pageParam.getId());
        params.put("roleName", pageParam.getName());
        params.put("pageIndex", pageParam.getPageIndex());
        params.put("pageSize", pageParam.getPageSize());
        List<SysRole> sysRoles = sysRoleService.qrySysRole(params);
        int roleCounts = sysRoleService.qrySysRoleCounts(params);
        JSONObject ret = new JSONObject();
        ret.put("counts", roleCounts);
        ret.put("pageIndex", pageParam.getPageIndex());
        ret.put("pageSize", pageParam.getPageSize());
        ret.put("rows", JSON.toJSON(sysRoles));
        return ApiResult.ok(ret, "查询成功！");
    }


    @Log("添加用户角色")
    @PostMapping("/addSysRole")
    @ApiOperation(value = "添加用户角色", notes = "添加用户角色")
    public ApiResult addSysRole(@Validated @RequestBody SysRoleParam sysRoleParam, HttpServletResponse response) {
        return sysRoleService.addSysRole(sysRoleParam);
    }

    @Log("修改用户角色")
    @PostMapping("/updateSysRole")
    @ApiOperation(value = "修改用户角色", notes = "修改用户角色")
    public ApiResult updateSysRole(@Validated @RequestBody SysRoleParam sysRoleParam, HttpServletResponse response) {

        return sysRoleService.updateSysRole(sysRoleParam);
    }

    @Log("删除用户角色")
    @PostMapping("/delSysRole")
    @ApiOperation(value = "删除用户角色", notes = "删除用户角色")
    public ApiResult delSysRole(@Validated @RequestBody BaseParam sysRoleParam, HttpServletResponse response) {

        return sysRoleService.delSysRole(sysRoleParam.getId());
    }


}
