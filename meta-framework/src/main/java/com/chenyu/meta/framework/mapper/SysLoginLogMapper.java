package com.chenyu.meta.framework.mapper;

import com.chenyu.meta.framework.domain.SysLoginLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 登录日志 Mapper
 */
@Component
public interface SysLoginLogMapper {

    /**
     * 保存
     *
     * @param sysLoginLog
     * @return
     */
    boolean saveSysLoginLog(SysLoginLog sysLoginLog);

    /**
     * 修改
     *
     * @param sysLoginLog
     * @return
     */
    boolean updateSysLoginLog(Map<String, Object> sysLoginLog);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deleteSysLoginLog(Long id);


    /**
     * 获取分页对象
     *
     * @param paramsMap
     * @return
     */
    List<SysLoginLog> getSysLoginLogPageList(Map<String, Object> paramsMap);

    /**
     * 获取登录日志的总数
     *
     * @param paramsMap
     * @return
     */
    int getSysLoginLogCount(Map<String, Object> paramsMap);




}
