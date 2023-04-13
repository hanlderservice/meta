package com.chenyu.meta.framework.service.impl;

import com.alibaba.fastjson2.JSON;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.framework.domain.SysOperationLog;
import com.chenyu.meta.framework.mapper.SysOperationLogMapper;
import com.chenyu.meta.framework.param.OperaLogInfoParam;
import com.chenyu.meta.framework.service.SysOperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Service
public class SysOperationLogServiceImpl implements SysOperationLogService {


    private Logger logger = LoggerFactory.getLogger(SysOperationLogService.class);

    @Autowired
    private SysOperationLogMapper sysOperationLogMapper;

    @Override
    public int saveSysOperationLog(SysOperationLog sysOperationLog) {
        return sysOperationLogMapper.saveSysOperationLog(sysOperationLog);
    }

    @Override
    public boolean updateSysOperationLog(Map<String, Object> sysOperationLog) {

        SysOperationLog sysOperationLog1 = null;
        try {
            sysOperationLog1 = BeanMapUtil.map2Bean(sysOperationLog, SysOperationLog.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysOperationLogMapper.updateSysOperationLog(sysOperationLog1);
    }

    @Override
    public boolean deleteSysOperationLog(Long id) {
        return sysOperationLogMapper.deleteSysOperationLog(id);
    }

    @Override
    public ApiResult getSysOperationLogPageList(OperaLogInfoParam params) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(params);
        logger.info(">>>>>>>>>>.转换后参数   " + paramsMap);
        List<SysOperationLog> logPageList = sysOperationLogMapper.getSysOperationLogPageList(paramsMap);
        int counts = sysOperationLogMapper.getSysOperationLogCount(paramsMap);
        Map<String, Object> ret = new HashMap<>();
        ret.put("rows", logPageList);
        ret.put("pageIndex", params.getPageIndex());
        ret.put("pageSize", params.getPageSize());
        ret.put("total", counts);
        logger.info(JSON.toJSONString(ret));
        return ApiResult.ok(ret);
    }
}
