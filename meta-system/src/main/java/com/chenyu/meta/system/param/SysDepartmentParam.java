package com.chenyu.meta.system.param;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("系统部门入参")
public class SysDepartmentParam  extends BaseParam {

    private String departmentId;
    private String deptName;
    private String deptCode;
    private String parentId;
    private String level;
    private String leader;
    private String phone;
    private String email;
    private String sort;
    private String remark;
    private String state;
    private String delFlag;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "SysDepartmentParam{" +
                "departmentId='" + departmentId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", parentId='" + parentId + '\'' +
                ", level='" + level + '\'' +
                ", leader='" + leader + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sort='" + sort + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
