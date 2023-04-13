package com.chenyu.meta.system.service;

import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.param.SysUmsUserListParam;
import com.chenyu.meta.system.param.SysUmsUserParam;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface UmsSysUserService {

    /**
     * 查询用户列表
     *
     * @param umsUserListParam
     * @return
     */
    ApiResult qrySysUmsUserList(SysUmsUserListParam umsUserListParam);

    /**
     * 添加用户信息
     *
     * @param umsUserParam
     * @return
     */
    ApiResult saveSysUmsUser(SysUmsUserParam umsUserParam);

    /**
     * 删除用户信息 --> 此处的删除是物理删除 只是修改用户的状态
     *
     * @param umsUserParam
     * @return
     */
    ApiResult delSysUmsUser(BaseParam umsUserParam);

    /**
     * 修改用户信息
     *
     * @param umsUserParam
     * @return
     */
    ApiResult updateSysUmsUser(SysUmsUserParam umsUserParam);

    /**
     * 批量删除用户信息
     *
     * @param umsUserParam
     * @return
     */
    ApiResult batchDelSysUmsUser(SysUmsUserParam umsUserParam);


}
