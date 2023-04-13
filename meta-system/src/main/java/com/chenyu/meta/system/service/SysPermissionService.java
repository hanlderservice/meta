package com.chenyu.meta.system.service;

import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.domain.SysPermission;
import com.chenyu.meta.system.param.SysPermissionParam;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
public interface SysPermissionService {

    /**
     * 根据用户查询权限
     *
     * @param baseParam
     * @return
     */
    ApiResult queryPermissionMenus(BaseParam baseParam);

    /**
     * @param baseParam
     * @return
     */

    ApiResult queryPermissionSysMenusList(BaseParam baseParam);

    /**
     * 添加菜单权限
     *
     * @param sysPermission
     * @return
     */
    boolean addSysPermission(SysPermissionParam sysPermission);

    /**
     * 修改系统
     *
     * @param sysPermission
     * @return
     */
    boolean updateSysPermission(SysPermission sysPermission);

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    boolean deletePermissionById(String id);

}
