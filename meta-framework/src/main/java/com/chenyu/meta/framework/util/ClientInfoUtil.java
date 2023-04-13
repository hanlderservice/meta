package com.chenyu.meta.framework.util;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.chenyu.meta.common.util.IPUtils;
import com.chenyu.meta.framework.domain.ClientInfo;
import com.chenyu.meta.framework.domain.DeviceInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 客户端工具类
 */
public class ClientInfoUtil {


    private static final Pattern DEVICE_INFO_PATTERN = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?Build/(\\S*?)[;)]");
    private static final Pattern DEVICE_INFO_PATTERN_1 = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?\\)");

    /**
     * 获取用户客户端信息
     *
     * @param request
     * @return
     */
    public static ClientInfo get(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return get(userAgent);
    }

    public static ClientInfo get(String userAgentStr) {
        ClientInfo clientInfo = new ClientInfo();
//        UserAg
        UserAgent userAgent = UserAgentUtil.parse(userAgentStr);
        //浏览器名称
        clientInfo.setBrowserName(userAgent.getBrowser().getName());
        //浏览器版本
        clientInfo.setBrowserVersion(userAgent.getVersion());
        //浏览器引擎名称
        clientInfo.setEngineName(userAgent.getEngine().getName());
        //浏览器引擎版本
        clientInfo.setEngineVersion(userAgent.getEngineVersion());
        //用户操作系统名称
        clientInfo.setOsName(userAgent.getOs().getName());
        //用户操作平台名称
        clientInfo.setPlatformName(userAgent.getPlatform().getName());
        //是否是手机
        clientInfo.setMobile(userAgent.isMobile());
        //获取移动设备名称和机型
        DeviceInfo deviceInfo = getDeviceInfo(userAgentStr);
        clientInfo.setDeviceName(deviceInfo.getName());
        clientInfo.setDeviceModel(deviceInfo.getModel());
        clientInfo.setIp(IPUtils.getRequestIP());//ip

        return clientInfo;
    }

    /**
     * 火狐移动端用户设备名称和机型
     *
     * @param userAgentStr
     * @return
     */
    public static DeviceInfo getDeviceInfo(String userAgentStr) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            Matcher matcher = DEVICE_INFO_PATTERN.matcher(userAgentStr);
            String model = null;
            String name = null;
            if (matcher.find()) {
                model = matcher.group(1);
                name = matcher.group(2);
            }
            if (model == null && name == null) {
                matcher = DEVICE_INFO_PATTERN_1.matcher(userAgentStr);
                if (matcher.find()) {
                    model = matcher.group(1);
                }
            }
            deviceInfo.setName(name);
            deviceInfo.setModel(model);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return deviceInfo;


    }


}
