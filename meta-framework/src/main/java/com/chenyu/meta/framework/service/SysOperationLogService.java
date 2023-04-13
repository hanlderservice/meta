package com.chenyu.meta.framework.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.framework.domain.SysOperationLog;
import com.chenyu.meta.framework.param.OperaLogInfoParam;

import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 系统操作服务类
 */
public interface SysOperationLogService {


    /**
     * 保存日志
     *
     * @param sysOperationLog
     * @return
     */
    int saveSysOperationLog(SysOperationLog sysOperationLog);

    /**
     * 更新日志
     *
     * @param sysOperationLog
     * @return
     */
    boolean updateSysOperationLog(Map<String, Object> sysOperationLog);

    /**
     * 删除日志
     *
     * @param id
     * @return
     */
    boolean deleteSysOperationLog(Long id);

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    ApiResult getSysOperationLogPageList(OperaLogInfoParam params);


}
