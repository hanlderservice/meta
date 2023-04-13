package com.chenyu.meta.system.service;

import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.domain.SysDepartment;
import com.chenyu.meta.system.param.SysDepartmentParam;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysDepartmentService {

    /**
     * 通过Id查询部门信息
     *
     * @param params
     * @return
     */
    List<SysDepartment> qrySysDepartmentById(Map<String, Object> params);

    /**
     * 查询部门列表
     *
     * @param params
     * @return
     */
    ApiResult qrySysDepartmentList(Map<String, Object> params);

    /**
     * 添加部门信息
     *
     * @param params
     * @return
     */

    ApiResult insertSysDepartment(Map<String, Object> params);

    /**
     * 修改部门信息
     *
     * @param departmentParam
     * @return
     */
    ApiResult updateSysDepartment(SysDepartmentParam departmentParam);
}


