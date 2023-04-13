package com.chenyu.meta.system.service;

import java.util.Set;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysRolePermissionService {

    Set<String> getPermissionCodesByRoleId(Long roleId);

}
