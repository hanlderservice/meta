package com.chenyu.meta.system.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysRolePermissionMapper {

    /**
     * 根据RoleId 查询权限
     *
     * @param roleId
     * @return
     */
    Set<String> getPermissionCodesByRoleId(@Param("roleId") Long roleId);


}
