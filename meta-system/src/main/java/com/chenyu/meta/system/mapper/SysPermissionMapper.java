package com.chenyu.meta.system.mapper;

import com.chenyu.meta.system.domain.SysPermission;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
public interface SysPermissionMapper {

    /**
     * 根据ID查询部门
     *
     * @param paramsMap 参数
     * @return 部门
     */
    Map<String, Object> getSysPermissionById(Map<String, Object> paramsMap);

    /**
     * 分页获取权限
     *
     * @param paramsMap 参数
     * @return ""
     */
    List<SysPermission> getSysPermissionPageList(Map<String, Object> paramsMap);


    /**
     * 根绝用户ID查询菜单
     *
     * @param paramsMap 参数
     * @return ""
     */
    List<Map<String, Object>> getMenuListByUserId(Map<String, Object> paramsMap);

    /**
     * 保存
     *
     * @param paramsMap 参数
     * @return 1
     */
    boolean saveSysPermission(Map<String, Object> paramsMap);

    /**
     * 修改
     *
     * @param paramsMap 参数
     * @return 1
     */
    boolean updateSysRolePermission(Map<String, Object> paramsMap);

    /**
     * 删除
     *
     * @param id id
     * @return 1
     */
    boolean deleteSysPermissionById(String id);

    /**
     * 根据用户Id查询 菜单
     *
     * @param userId 用户ID
     * @return 菜单
     */
    List<SysPermission> qrySysPermMenuByUserId(String userId);

    /**
     * 根据用户Id查询 菜单树
     *
     * @param userId
     * @return
     */
    List<SysPermission> qryMenuTreeAll(String userId);



}
