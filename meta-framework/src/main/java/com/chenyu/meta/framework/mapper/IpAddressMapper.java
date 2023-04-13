package com.chenyu.meta.framework.mapper;

import com.chenyu.meta.framework.domain.IpAddress;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public interface IpAddressMapper {

    /**
     * 根据IP查询 IP信息
     *
     * @param ip
     * @return
     */
    IpAddress queryAreaByIp(@Param("ip") String ip);

    /**
     * 保存 ip 信息
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
