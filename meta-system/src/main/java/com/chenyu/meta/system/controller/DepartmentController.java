package com.chenyu.meta.system.controller;

import com.chenyu.meta.common.param.BasePageParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.BeanMapUtil;
import com.chenyu.meta.framework.aop.annotation.Log;
import com.chenyu.meta.system.param.SysDepartmentParam;
import com.chenyu.meta.system.service.SysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@RestController
@RequestMapping("/systemDeptApi")
@Api(value = "系统部门管理API", tags = {"系统部门管理API"})
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Log("查询部门列表")
    @PostMapping("/qryDeptList")
    @ApiOperation(value = "部门列表", notes = "部门列表")
    public ApiResult qryDeptList(@Validated @RequestBody BasePageParam pageParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>部门列表>>>>>" + pageParam);
        Map<String, Object> map = BeanMapUtil.bean2Map(pageParam);
        return sysDepartmentService.qrySysDepartmentList(map);
    }

    @Log("添加部门")
    @PostMapping("/insertDeptInfo")
    @ApiOperation(value = "添加部门", notes = "添加部门")
    public ApiResult insertDeptInfo(@Validated @RequestBody SysDepartmentParam departmentParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>添加部门>>>>>" + departmentParam);
        Map<String, Object> map = BeanMapUtil.bean2Map(departmentParam);

        return sysDepartmentService.insertSysDepartment(map);
    }

    @Log("修改部门")
    @PostMapping("/updateDeptInfo")
    @ApiOperation(value = "修改部门", notes = "修改部门")
    public ApiResult updateDeptInfo(@Validated @RequestBody SysDepartmentParam departmentParam, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>添加部门>>>>>" + departmentParam);
        Map<String, Object> map = BeanMapUtil.bean2Map(departmentParam);

        return sysDepartmentService.updateSysDepartment(departmentParam);
    }


}
