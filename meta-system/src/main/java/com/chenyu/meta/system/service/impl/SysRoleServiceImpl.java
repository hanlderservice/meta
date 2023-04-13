package com.chenyu.meta.system.service.impl;

import com.chenyu.meta.common.util.ApiCode;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.system.domain.SysRole;
import com.chenyu.meta.system.mapper.SysRoleMapper;
import com.chenyu.meta.system.param.SysRoleParam;
import com.chenyu.meta.system.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> qrySysRole(Map<String, Object> params) {
        return sysRoleMapper.qrySysRole(params);

    }

    @Override
    public int qrySysRoleCounts(Map<String, Object> params) {
        return sysRoleMapper.qrySysRoleCounts(params);
    }

    @Override
    public ApiResult addSysRole(SysRoleParam sysRoleParam) {
        ApiCode apiCode = null;
        String message = "";
        try {
            Map<String, Object> map = BeanMapUtil.bean2Map(sysRoleParam);
            boolean sysRole = sysRoleMapper.addSysRole(map);
            if (sysRole) {
                apiCode = ApiCode.SUCCESS;
                message = apiCode.getMessage();
            } else {
                apiCode = ApiCode.FAIL;
                message = apiCode.getMessage();
            }

        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>> 添加用户角色失败>>>>", e);
            apiCode = ApiCode.SYSTEM_EXCEPTION;
            message = apiCode.getMessage() + "【" + e.getMessage() + "】";
        }

        return ApiResult.result(apiCode, message, "");
    }

    @Override
    public ApiResult updateSysRole(SysRoleParam sysRoleParam) {
        ApiCode apiCode = null;
        String message = "";
        try {
            Map<String, Object> map = BeanMapUtil.bean2Map(sysRoleParam);
            boolean sysRole = sysRoleMapper.updateSysRole(map);
            if (sysRole) {
                apiCode = ApiCode.SUCCESS;
                message = apiCode.getMessage();
            } else {
                apiCode = ApiCode.FAIL;
                message = apiCode.getMessage();
            }

        } catch (Exception e) {
            logger.info(">>>>>>>>>>>>>修改失败.", e);
            apiCode = ApiCode.SYSTEM_EXCEPTION;
            message = apiCode.getMessage() + "【" + e.getMessage() + "】";
        }

        return ApiResult.result(apiCode, message, "");
    }

    @Override
    public ApiResult delSysRole(String roleId) {
        ApiCode apiCode = null;
        String message = "";
        try {
            boolean sysRole = sysRoleMapper.delSysRole(roleId);
            if (sysRole) {
                apiCode = ApiCode.SUCCESS;
                message = apiCode.getMessage();
            } else {
                apiCode = ApiCode.FAIL;
                message = apiCode.getMessage();
            }

        } catch (Exception e) {
            logger.info(">>>>>>>>>>>>>修改失败.", e);
            apiCode = ApiCode.SYSTEM_EXCEPTION;
            message = apiCode.getMessage() + "【" + e.getMessage() + "】";
        }


        return ApiResult.result(apiCode, message, "");
    }


}
