package com.chenyu.meta.system.controller;

import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.domain.UosNotice;
import com.chenyu.meta.system.param.UosNoticeParam;
import com.chenyu.meta.system.service.UosNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@RestController
@RequestMapping("/systemNoticeApi")
@Api(value = "系统消息通知API", tags = {"系统消息通知"})
public class MessageNoticeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UosNoticeService uosNoticeService;


    @Log("查询系统通知消息列表")
    @PostMapping("/qryNoticeList")
    @ApiOperation(value = "系统通知消息列表", notes = "系统通知消息列表")
    public ApiResult qryNoticeList(@Validated @RequestBody UosNoticeParam noticeParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>系统通知消息请求参数>>>>>>>>>>>noticeParam:{}", noticeParam);

        return uosNoticeService.qryUosNotice(noticeParam);
    }

    @Log("修改系统通知消息")
    @PostMapping("/updateNotice")
    @ApiOperation(value = "修改系统通知消息", notes = "修改系统通知消息")
    public ApiResult updateNotice(@Validated @RequestBody BaseParam noticeParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>系统通知消息请求参数>>>>>>>>>>>noticeParam:{}", noticeParam);
        String paramId = noticeParam.getId();
        String[] split = paramId.split(",");
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("isRead", "1");
            map.put("noticeId", split[i]);
            map.put("username", noticeParam.getName());
            list.add(map);
        }
        return uosNoticeService.updateUosNotice(list);
    }

    @Log("查询系统通知消息类型")
    @PostMapping("/qryNoticeType")
    @ApiOperation(value = "系统通知消息类型", notes = "系统通知消息类型")
    public ApiResult qryNoticeType(@Validated @RequestBody BaseParam noticeParam, HttpServletResponse response) {
        Map<String, Object> map = BeanMapUtil.bean2Map(noticeParam);
        return uosNoticeService.qryUosNoticeType(map);
    }

    @Log("删除系统通知消息")
    @PostMapping("/deleteNotice")
    @ApiOperation(value = "删除系统通知消息", notes = "删除系统通知消息")
    public ApiResult deleteNotice(@Validated @RequestBody BaseParam noticeParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>删除系统通知消息请求参数>>>>>>>>>>>noticeParam:{}", noticeParam);
        String paramId = noticeParam.getId();
        String[] split = paramId.split(",");
        List<Map<String, Object>> list = new ArrayList<>();
        for (String aSplit : split) {
            Map<String, Object> map = new HashMap<>();
            map.put("noticeId", aSplit);
            map.put("state", "10X");
            map.put("username", noticeParam.getName());
            list.add(map);
        }
        return uosNoticeService.deleteUosNotice(list);
    }


}
