package com.chenyu.meta.system.service.impl;

import com.chenyu.meta.common.util.ApiCode;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.system.domain.UosNotice;
import com.chenyu.meta.system.mapper.UosNoticeMapper;
import com.chenyu.meta.system.param.UosNoticeParam;
import com.chenyu.meta.system.service.UosNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@Service
public class UosNoticeServiceImpl implements UosNoticeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UosNoticeMapper noticeMapper;

    @Override
    public ApiResult qryUosNotice(UosNoticeParam noticeParam) {

        ApiCode apiCode = null;
        Map<String, Object> result = new HashMap<>();
        try {
            Map<String, Object> paramsMap = BeanMapUtil.bean2Map(noticeParam);
            List<UosNotice> uosNotices = noticeMapper.qryUosNoticeList(paramsMap);
            int counts = noticeMapper.qryUosNoticeCounts(paramsMap);
            result.put("rows", uosNotices);
            result.put("pageIndex", noticeParam.getPageIndex());
            result.put("pageSize", noticeParam.getPageSize());
            result.put("total", counts);
            apiCode = ApiCode.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            apiCode = ApiCode.FAIL;
        }
        return ApiResult.result(apiCode, result);
    }

    @Override
    public ApiResult updateUosNotice(List<Map<String, Object>> params) {
        ApiCode apiCode = null;
        try {
            boolean uosNotice = noticeMapper.updateUosNotice(params);
            apiCode = ApiCode.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>>.", e);
            apiCode = ApiCode.FAIL;
        }
        return ApiResult.result(apiCode);
    }

    @Override
    public ApiResult qryUosNoticeType(Map<String, Object> params) {

        List<Map<String, Object>> maps = noticeMapper.qryUosNoticeType(params);
        return ApiResult.ok(maps);
    }

    @Override
    public ApiResult deleteUosNotice(List<Map<String, Object>> params) {
        boolean uosNotice = noticeMapper.deleteUosNotice(params);
        if (uosNotice) {
            return ApiResult.ok();
        }
        return ApiResult.fail("删除失败！");
    }

    @Override
    public ApiResult saveUosNoticeType(Map<String, Object> params) {
        boolean noticeType = noticeMapper.saveUosNoticeType(params);
        if (noticeType) {
            return ApiResult.ok();
        }
        return ApiResult.fail();
    }
}
