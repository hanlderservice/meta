package com.chenyu.meta.framework.service.impl;

import com.alibaba.fastjson2.JSON;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.framework.domain.SysLoginLog;
import com.chenyu.meta.framework.mapper.SysLoginLogMapper;
import com.chenyu.meta.framework.param.LoginLogInfoParam;
import com.chenyu.meta.framework.service.SysLoginLogService;
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
public class SysLoginLogServiceImpl implements SysLoginLogService {



    private Logger logger = LoggerFactory.getLogger(SysOperationLogService.class);

    @Autowired
    private SysLoginLogMapper loginLogMapper;

    @Override
    public boolean saveSysLoginLog(SysLoginLog sysLoginLog) {
        return loginLogMapper.saveSysLoginLog(sysLoginLog);
    }

    @Override
    public ApiResult getSysLoginLogPageList(LoginLogInfoParam params) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(params);
        List<SysLoginLog> pageList = loginLogMapper.getSysLoginLogPageList(paramsMap);
        int counts = loginLogMapper.getSysLoginLogCount(paramsMap);

        Map<String, Object> ret = new HashMap<>();
        ret.put("rows", pageList);
        ret.put("pageIndex", params.getPageIndex());
        ret.put("pageSize", params.getPageSize());
        ret.put("total", counts);


        logger.info(JSON.toJSONString(ret));

        return ApiResult.ok(ret);
    }


}
