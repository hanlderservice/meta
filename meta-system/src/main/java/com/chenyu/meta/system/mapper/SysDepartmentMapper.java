package com.chenyu.meta.system.mapper;

import com.chenyu.meta.system.domain.SysDepartment;
import com.chenyu.meta.system.param.SysDepartmentParam;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public interface SysDepartmentMapper {


    List<SysDepartment> qrySysDepartmentById(Map<String, Object> params);

    /**
     * 查询部门列表
     *
     * @param params
     * @return
     */
    List<SysDepartment> qrySysDepartmentList(Map<String, Object> params);

    /**
     * 查询部门总数
     *
     * @param params
     * @return
     */
    int qrySysDepartmentCounts(Map<String, Object> params);

    /**
     * 新增部门信息
     *
     * @param params
     * @return
     */
    int insertSysDepartment(Map<String, Object> params);

    /**
     * 修改部门信息
     *
     * @param departmentParam
     * @return
     */
    int updateSysDepartment(SysDepartmentParam departmentParam);

}
