package com.chenyu.meta.framework.service.impl;

import com.chenyu.meta.framework.domain.IpAddress;
import com.chenyu.meta.framework.mapper.IpAddressMapper;
import com.chenyu.meta.framework.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Service
public class IpAddressServiceImpl implements IpAddressService {


    @Autowired
    private IpAddressMapper ipAddressMapper;


    @Override
    public IpAddress queryAreaByIp(String ip) {

        return ipAddressMapper.queryAreaByIp(ip);
    }

    @Override
    public int saveHostIp(Map<String, Object> params) {
        return ipAddressMapper.saveHostIp(params);
    }

    @Override
    public IpAddress queryIpAddress(Map<String, Object> params) {
        return ipAddressMapper.queryIpAddress(params);
    }

    @Override
    public int updateIpAddress(Map<String, Object> params) {
        return ipAddressMapper.updateIpAddress(params);
    }


}
