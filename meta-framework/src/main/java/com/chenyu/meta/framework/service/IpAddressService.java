package com.chenyu.meta.framework.service;

import com.chenyu.meta.framework.domain.IpAddress;

import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public interface IpAddressService {

    /**
     * 根据IP查询IP归属地
     *
     * @param ip ip
     * @return 0
     */
    IpAddress queryAreaByIp(String ip);

    /**
     * 插入IP信息
     *
     * @param params
     * @return
     */
    int saveHostIp(Map<String, Object> params);

    /**
     * 查询IP 地址信息
     *
     * @param params
     * @return
     */
    IpAddress queryIpAddress(Map<String, Object> params);

    /**
     * 修改IP 地址信息
     *
     * @param params
     * @return
     */
    int updateIpAddress(Map<String, Object> params);


}
