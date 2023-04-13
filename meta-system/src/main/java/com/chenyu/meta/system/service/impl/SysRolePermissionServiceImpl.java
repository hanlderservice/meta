package com.chenyu.meta.system.service.impl;

import com.chenyu.meta.system.mapper.SysRolePermissionMapper;
import com.chenyu.meta.system.service.SysRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    @Override
    public Set<String> getPermissionCodesByRoleId(Long roleId) {
        return rolePermissionMapper.getPermissionCodesByRoleId(roleId);

    }


}
