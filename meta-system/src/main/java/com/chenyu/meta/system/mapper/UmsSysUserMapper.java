package com.chenyu.meta.system.mapper;

import com.chenyu.meta.system.domain.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Component
public interface UmsSysUserMapper {


    /**
     * 账号密码查询用户信息
     *
     * @param params
     * @return
     */
    List<SysUser> qrySysUser(Map<String, Object> params);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    List<SysUser> qrySysUmsUserByUserName(String username);

    /**
     * @param params
     * @return
     */
    List<Map<String, Object>> qrySysUmsUserList(Map<String, Object> params);

    int qrySysUmsUserCounts(Map<String, Object> params);

    /**
     * 添加用户信息
     *
     * @param umsUserParam
     * @return
     */
    int saveSysUmsUser(Map<String, Object> umsUserParam);

    /**
     * 修改用户信息
     *
     * @param umsUserParam
     * @return
     */
    int updateSysUmsUser(Map<String, Object> umsUserParam);

    /**
     * 批量删除
     *
     * @param umsUserParam
     * @return
     */
    int batchDelSysUmsUser(List<String> umsUserParam);

    /**
     * 重置密码
     *
     * @param paramsMap
     * @return
     */
    boolean resetPassword(Map<String, Object> paramsMap);


}
