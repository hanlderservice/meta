package com.chenyu.meta.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.system.domain.SysUser;
import com.chenyu.meta.system.mapper.UmsSysUserMapper;
import com.chenyu.meta.system.param.SysUmsUserListParam;
import com.chenyu.meta.system.param.SysUmsUserParam;
import com.chenyu.meta.system.service.UmsSysUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Service
public class UmsSysUserServiceImpl implements UmsSysUserService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UmsSysUserMapper umsSysUserMapper;

    @Override
    public ApiResult qrySysUmsUserList(SysUmsUserListParam umsUserListParam) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(umsUserListParam);
        logger.info(">>>>>>>>>>>>>>.转换后" + paramsMap);
        List<Map<String, Object>> maps = umsSysUserMapper.qrySysUmsUserList(paramsMap);

        int umsUserCounts = umsSysUserMapper.qrySysUmsUserCounts(paramsMap);
        JSONObject ret = new JSONObject();
        ret.put("counts", umsUserCounts);
        ret.put("pageIndex", umsUserListParam.getPageIndex());
        ret.put("pageSize", umsUserListParam.getPageSize());
        ret.put("rows", JSON.toJSON(maps));

        return ApiResult.ok(ret, "查询成功!");
    }

    @Override
    public ApiResult saveSysUmsUser(SysUmsUserParam umsUserParam) {
        Map<String, Object> paramsMap = BeanMapUtil.bean2Map(umsUserParam);
        logger.info(">>>>>>>>>>>>>>.转换后" + paramsMap);
        //先校验用户名是否存在
        int umsUser = 0;
        try {
            List<SysUser> sysUsers = umsSysUserMapper.qrySysUmsUserByUserName(umsUserParam.getUsername());
            logger.info(">>>>>>>>>>>>>>>mapList:::" + sysUsers);
            if (CollectionUtils.isNotEmpty(sysUsers)) {
                return ApiResult.fail("用户名已存在！");
            }

            umsUser = umsSysUserMapper.saveSysUmsUser(paramsMap);
            logger.info(">>>>>>>" + umsUser);
            return ApiResult.ok(umsUser, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>.用户信息保存失败!", e);
            return ApiResult.fail("用户信息保存失败:" + e.getMessage());

        }


    }

    @Override
    public ApiResult delSysUmsUser(BaseParam umsUserParam) {

        Map<String, Object> params = new HashMap<>();
        try {
            params.put("userId", umsUserParam.getId());
            //TODO 这个根据token 从缓存中获取
            params.put("username", "");
            params.put("deleted", "1");
            int umsUser = umsSysUserMapper.updateSysUmsUser(params);
            return ApiResult.ok(umsUser, "用户信息删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>.用户信息删除失败!", e);
            return ApiResult.fail("用户信息删除失败:" + e.getMessage());
        }

    }

    @Override
    public ApiResult updateSysUmsUser(SysUmsUserParam umsUserParam) {
        try {
            Map<String, Object> paramsMap = BeanMapUtil.bean2Map(umsUserParam);
            logger.info(">>>>>>>>>>>>>>.转换后" + paramsMap);
            int umsUser = umsSysUserMapper.updateSysUmsUser(paramsMap);
            return ApiResult.ok(umsUser, "用户信息修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>.用户信息修改失败!", e);
            return ApiResult.fail("用户信息修改失败:" + e.getMessage());
        }

    }

    @Override
    public ApiResult batchDelSysUmsUser(SysUmsUserParam umsUserParam) {
        try {
            Map<String, Object> paramsMap = BeanMapUtil.bean2Map(umsUserParam);
            logger.info(">>>>>>>>>>>>>>.转换后" + paramsMap);
            umsSysUserMapper.batchDelSysUmsUser(new ArrayList<>());
            return ApiResult.ok("用户信息删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>.批量删除用户信息失败!", e);
            return ApiResult.fail("批量删除用户信息失败:" + e.getMessage());
        }


    }
}