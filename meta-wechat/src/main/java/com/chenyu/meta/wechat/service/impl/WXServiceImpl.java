package com.chenyu.meta.wechat.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.util.StrengthenRestTemplate;
import com.chenyu.meta.wechat.domain.WxAccessToken;
import com.chenyu.meta.wechat.service.WXService;
import com.chenyu.meta.wechat.util.WxUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class WXServiceImpl implements WXService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static WxAccessToken wxAccessToken;

    private static Map<String, WxAccessToken> wxAccessTokens = new HashMap<>();

    @Autowired
    private StrengthenRestTemplate restTemplate;
//    @Autowired
//    private ConfigAdapterService configAdapterService;
//    @Autowired
//    private WxAccountConfigService wxAccountConfigService;


    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        return WxUtils.checkSignature(timestamp, nonce, signature);
    }

    @Override
    public String getAccessToken() {
        try {
            if (wxAccessToken != null && !wxAccessToken.isExpired()) {
                return wxAccessToken.getAccessToken();
            } else {
                wxAccessToken = requestToken("");
            }
        } catch (Exception e) {
            logger.error("获取access_token 失败>>>>>>:", e.getMessage());
            e.printStackTrace();
        }
        return wxAccessToken.getAccessToken();
    }

    /**
     * 请求网络获取token
     *
     * @param appId
     * @return WxAccessToken
     */
    private WxAccessToken requestToken(String appId) {
        JSONObject resData = getToken(appId);
        String errCode = MapUtils.getString(resData, "errcode");
        boolean b = StringUtils.isNotBlank(errCode) && (("42001").equals(errCode)
                || ("40001").equals(errCode) || ("40014").equals(errCode));
        if (b) {
            resData = getToken(appId);
        }
        String accessToken = MapUtils.getString(resData, "access_token");
        int expiresIn = MapUtils.getIntValue(resData, "expires_in");
        return new WxAccessToken(accessToken, expiresIn);
    }


    @Override
    public String getAccessToken(boolean forceRefresh) {

        if (forceRefresh) {
            wxAccessToken = null;
        }
        return getAccessToken();
    }

    @Override
    public String getAccessToken(String appId) {

        try {
            if (StringUtils.isNotEmpty(appId)) {
                WxAccessToken wxAccessToken = wxAccessTokens.get(appId);
                if (wxAccessToken != null && !wxAccessToken.isExpired()) {
                    return wxAccessToken.getAccessToken();
                } else {
                    wxAccessToken = requestToken(appId);
                    wxAccessTokens.put(appId, wxAccessToken);
                }
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>获取token失败", e.getMessage());
            e.printStackTrace();
        }
        return wxAccessToken.getAccessToken();
    }

    @Override
    public String getAccessToken(boolean forceRefresh, String appId) {
        if (forceRefresh) {
            WxAccessToken wxAccessToken = wxAccessTokens.get(appId);
            wxAccessToken = null;
        }
        return getAccessToken(appId);
    }


    private JSONObject getToken(String appId) {
//        String access_token = configAdapterService.queryConfig("access_token");
//        Map<String, Object> params = new HashMap<>();
//        if (StringUtils.isNotEmpty(appId)) {
//            params.put("appid", appId);
//        }
//        List<Map<String, Object>> mapList = wxAccountConfigService.qryWxAccountConfig(params);
//        if (mapList.isEmpty()) {
//
//            throw new RuntimeException("微信账号未配置！");
//        }
//        Map<String, Object> stringObjectMap = mapList.get(0);
//        String appIdNew = MapUtils.getString(stringObjectMap, "appid");
//        String appSecret = MapUtils.getString(stringObjectMap, "appsecret");

//        String url = String.format(access_token, appIdNew, appSecret);
        String url = "";
        logger.info(">>>>>>>>>>>>>WXServiceImpl.getToken: Url" + url);
        ResponseEntity<JSONObject> entity = restTemplate.get(url, JSONObject.class);
        logger.info(">>>>>>>>>>>>>>>>>" + entity);
        return entity.getBody();
    }




}
