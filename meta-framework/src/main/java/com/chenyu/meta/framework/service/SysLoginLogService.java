package com.chenyu.meta.framework.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.domain.SysLoginLog;
import com.chenyu.meta.framework.param.LoginLogInfoParam;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 登录日志记录服务类
 */
public interface SysLoginLogService {


    /**
     * 保存登录日志
     *
     * @param sysLoginLog
     * @return
     */

    boolean saveSysLoginLog(SysLoginLog sysLoginLog);

    /**
     * 获取登录日志
     *
     * @param params
     * @return
     */
    ApiResult getSysLoginLogPageList(LoginLogInfoParam params);




}
