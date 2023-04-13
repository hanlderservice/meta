package com.chenyu.meta.system.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.param.UosNoticeParam;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
public interface UosNoticeService {

    ApiResult qryUosNotice(UosNoticeParam noticeParam);

    ApiResult updateUosNotice(List<Map<String, Object>> params);

    ApiResult qryUosNoticeType(Map<String, Object> params);

    ApiResult deleteUosNotice(List<Map<String, Object>> params);

    ApiResult saveUosNoticeType(Map<String, Object> params);

}
