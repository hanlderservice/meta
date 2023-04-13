package com.chenyu.meta.framework.mapper;

import com.chenyu.meta.framework.domain.SysOperationLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
public interface SysOperationLogMapper {

    /**
     * 保存日志
     *
     * @param sysOperationLog
     * @return
     * @
     */
    int saveSysOperationLog(SysOperationLog sysOperationLog);

    /**
     * 更新日志
     *
     * @param sysOperationLog
     * @return
     * @
     */
    boolean updateSysOperationLog(SysOperationLog sysOperationLog);

    /**
     * 删除日志
     *
     * @param id
     * @return
     * @
     */
    boolean deleteSysOperationLog(Long id);

    /**
     * 分页查询
     *
     * @param paramsMap
     * @return
     * @
     */
    List<SysOperationLog> getSysOperationLogPageList(Map<String, Object> paramsMap);

    /**
     * 获取系统操作日志总数
     *
     * @param paramsMap
     * @return
     */
    int getSysOperationLogCount(Map<String, Object> paramsMap);


}
