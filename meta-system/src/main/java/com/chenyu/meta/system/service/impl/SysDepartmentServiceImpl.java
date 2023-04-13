package com.chenyu.meta.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.TreeNodeUtils;
import com.chenyu.meta.system.domain.SysDepartment;
import com.chenyu.meta.system.domain.SysDepartmentTreeNode;
import com.chenyu.meta.system.mapper.SysDepartmentMapper;
import com.chenyu.meta.system.param.SysDepartmentParam;
import com.chenyu.meta.system.service.SysDepartmentService;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<SysDepartment> qrySysDepartmentById(Map<String, Object> params) {

        logger.info(">>>>>>>>>>>>查询部门信息" + JSONObject.toJSONString(params));
        List<SysDepartment> sysDepartments = sysDepartmentMapper.qrySysDepartmentById(params);
        logger.info(">>>>>>>>>>>>>>>部门信息响应" + JSONObject.toJSONString(sysDepartments));
        return sysDepartmentMapper.qrySysDepartmentById(params);

    }

    @Override
    public ApiResult qrySysDepartmentList(Map<String, Object> params) {

        logger.info(">>>>>>>>>>>>查询部门列表信息::::" + JSONObject.toJSONString(params));
        List<SysDepartment> sysDepartments = sysDepartmentMapper.qrySysDepartmentList(params);
        List buildTreeNode = buildTreeNode(sysDepartments);
        logger.info(">>>>>>>>>>. " + JSONObject.toJSONString(buildTreeNode));
        int counts = sysDepartmentMapper.qrySysDepartmentCounts(params);
        JSONObject ret = new JSONObject();
        ret.put("counts", counts);
        ret.put("pageIndex", MapUtils.getIntValue(params, "pageIndex"));
        ret.put("pageSize", MapUtils.getIntValue(params, "pageSize"));
//        ret.put("rows", JSONObject.parse(buildTreeNode + ""));
        ret.put("rows", JSON.toJSON(buildTreeNode));

        logger.info(">>>>>>>>>>>>>>" + JSONObject.toJSONString(ret));
        return ApiResult.ok(ret, "查询成功");
    }

    @Override
    public ApiResult insertSysDepartment(Map<String, Object> params) {


        int i = sysDepartmentMapper.insertSysDepartment(params);


        return ApiResult.ok("添加成功!");
    }

    @Override
    public ApiResult updateSysDepartment(SysDepartmentParam departmentParam) {
        int i = sysDepartmentMapper.updateSysDepartment(departmentParam);
        return ApiResult.ok("修改成功!");
    }

    private List buildTreeNode(List<SysDepartment> sysDepartments) {

        List<SysDepartmentTreeNode> treeNodes = new ArrayList<>();

        for (SysDepartment sysDepartment : sysDepartments) {

            SysDepartmentTreeNode treeNode = new SysDepartmentTreeNode();
            treeNode.setCreateBy(sysDepartment.getCreateBy());
            treeNode.setCreateTime(sysDepartment.getCreateTime());

            treeNode.setDeptCode(sysDepartment.getDeptCode());
            treeNode.setDelFlag(sysDepartment.getDelFlag());
            treeNode.setDepartmentId(sysDepartment.getDepartmentId());
            treeNode.setDeptName(sysDepartment.getDeptName());
            treeNode.setParentId(sysDepartment.getParentId());
            treeNode.setRemark(sysDepartment.getRemark());
            treeNode.setState(sysDepartment.getState());
            treeNode.setSort(sysDepartment.getSort());
            treeNode.setpId(sysDepartment.getParentId());
            treeNode.setId(sysDepartment.getDepartmentId());
            treeNode.setName(sysDepartment.getDeptName());
            treeNode.setTitle(sysDepartment.getDeptName());
            treeNode.setValue(sysDepartment.getDepartmentId() + "");
            treeNode.setKey(sysDepartment.getDepartmentId() + "");
            treeNode.setLevel(sysDepartment.getLevel());
            treeNodes.add(treeNode);
        }

        return TreeNodeUtils.build(treeNodes);
    }


}

