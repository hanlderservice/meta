package com.chenyu.meta.system.mapper;

import com.chenyu.meta.system.domain.UosNotice;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
public interface UosNoticeMapper {


    /**
     * 保存通知
     *
     * @param params
     * @return
     */
    int saveUosNotice(Map<String, Object> params);

    /**
     * 查询通知列表
     *
     * @param params
     * @return
     */
    List<UosNotice> qryUosNoticeList(Map<String, Object> params);

    /**
     * 查询通知总数
     *
     * @param params
     * @return
     */
    int qryUosNoticeCounts(Map<String, Object> params);

    /**
     * 修改 通知
     *
     * @param params
     * @return
     */
    boolean updateUosNotice(List<Map<String, Object>> params);

    /**
     * 删除 通知消息
     *
     * @param params
     * @return
     */
    boolean deleteUosNotice(List<Map<String, Object>> params);


    /**
     * 保存通知类型
     *
     * @param params
     * @return
     */
    boolean saveUosNoticeType(Map<String, Object> params);

    /**
     * 查询通知类型列表
     *
     * @param params
     * @return
     */
    List<Map<String, Object>> qryUosNoticeType(Map<String, Object> params);


}
