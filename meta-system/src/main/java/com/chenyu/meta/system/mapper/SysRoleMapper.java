package com.chenyu.meta.system.mapper;

import com.chenyu.meta.system.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysRoleMapper {

    /**
     * 查询角色
     *
     * @param params
     * @return
     */
    List<SysRole> qrySysRole(Map<String, Object> params);

    /**
     * 查询角色总数
     *
     * @param params
     * @return
     */
    int qrySysRoleCounts(Map<String, Object> params);

    /**
     * 添加角色信息
     *
     * @param params
     * @return
     */
    boolean addSysRole(Map<String, Object> params);

    /**
     * 修改角色信息
     *
     * @param params
     * @return
     */
    boolean updateSysRole(Map<String, Object> params);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    boolean delSysRole(String roleId);
}
