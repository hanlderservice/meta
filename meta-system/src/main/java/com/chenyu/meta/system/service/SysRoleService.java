package com.chenyu.meta.system.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.domain.SysRole;
import com.chenyu.meta.system.param.SysRoleParam;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysRoleService {


    /**
     * 查询用户角色
     *
     * @param params
     * @return
     */
    List<SysRole> qrySysRole(Map<String, Object> params);

    /**
     * @param params
     * @return
     */
    int qrySysRoleCounts(Map<String, Object> params);

    /**
     * 添加用户角色
     *
     * @param sysRoleParam
     * @return
     */
    ApiResult addSysRole(SysRoleParam sysRoleParam);

    ApiResult updateSysRole(SysRoleParam sysRoleParam);

    ApiResult delSysRole(String roleId);


}
