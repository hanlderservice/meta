package com.chenyu.meta.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.param.BasePageParam;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.TreeNodeUtils;
import com.chenyu.meta.system.domain.SysPermission;
import com.chenyu.meta.system.domain.tree.MenuTreeNode;
import com.chenyu.meta.system.mapper.SysPermissionMapper;
import com.chenyu.meta.system.param.SysPermissionParam;
import com.chenyu.meta.system.service.SysPermissionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public ApiResult queryPermissionMenus(BaseParam baseParam) {
        List<SysPermission> sysPermissionPageList = null;
        if (StringUtils.isNoneEmpty(baseParam.getId()) && ("1").equals(baseParam.getId())) {
            sysPermissionPageList = sysPermissionMapper.getSysPermissionPageList(new HashMap<>());
        } else {
            Map<String, Object> params = new HashMap<>();
            params.put("id", baseParam.getId());
            sysPermissionPageList = sysPermissionMapper.getSysPermissionPageList(params);
        }
        logger.info(sysPermissionPageList.toString());
        List<MenuTreeNode> treeNodes = initTreeMenu(sysPermissionPageList);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>" + treeNodes.toString());
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("menuInfo", treeNodes);

        return ApiResult.ok(retMap);
    }

    @Override
    public ApiResult queryPermissionSysMenusList(BaseParam baseParam) {
        List<SysPermission> sysPermissionPageList = null;
        if (StringUtils.isNoneEmpty(baseParam.getId()) && ("1").equals(baseParam.getId())) {
            sysPermissionPageList = sysPermissionMapper.getSysPermissionPageList(new HashMap<>());
        } else {
            Map<String, Object> params = new HashMap<>();
            params.put("id", baseParam.getId() + "");
            sysPermissionPageList = sysPermissionMapper.getSysPermissionPageList(params);
        }


        return null;
    }


    @Override
    public boolean addSysPermission(SysPermissionParam sysPermission) {

        Map map = JSONObject.parseObject(JSONObject.toJSONString(sysPermission), Map.class);
        return sysPermissionMapper.saveSysPermission(map);
    }


    @Override
    public boolean updateSysPermission(SysPermission sysPermission) {
        Map map = JSONObject.parseObject(JSONObject.toJSONString(sysPermission), Map.class);
        sysPermissionMapper.updateSysRolePermission(map);
        return false;
    }

    @Override
    public boolean deletePermissionById(String id) {
        return false;
    }


    private List<MenuTreeNode> initTreeMenu(List<SysPermission> sysPermissionPageList) {
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissionPageList) {
            MenuTreeNode menuTreeNode = new MenuTreeNode();
            Long menuId = sysPermission.getMenuId();
            menuTreeNode.setId(menuId);
            menuTreeNode.setName(sysPermission.getMenuName());
            menuTreeNode.setTitle(sysPermission.getMenuName());
            menuTreeNode.setIcon(sysPermission.getIcon());
            menuTreeNode.setpId(sysPermission.getParentId());
            menuTreeNode.setComponents(sysPermission.getComponents());
            menuTreeNode.setKey(sysPermission.getComponents());
            treeNodes.add(menuTreeNode);
        }
        return TreeNodeUtils.build(treeNodes);
    }


}
