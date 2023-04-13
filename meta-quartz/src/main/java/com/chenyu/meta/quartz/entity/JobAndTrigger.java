package com.chenyu.meta.quartz.entity;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public class JobAndTrigger {

    /**
     * 任务id
     */
    private Long scheduleJobId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 任务别名
     */
    private String aliasName;


    /**
     * 定时任务全类名
     */
    private String jobClassName;


    /**
     * 任务运行时间表达式
     */
    private String cronExpression;

    /**
     * 任务状态 0禁用 1启用 2删除
     */
    private String isDurable;
    /**
     * 触发器
     */
    private String jobTrigger;

    /**
     * 是否异步
     */
    private String isSync;
    /**
     * 备注
     */
    private String jobDesc;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private String updateTime;

    public Long getScheduleJobId() {
        return scheduleJobId;
    }

    public void setScheduleJobId(Long scheduleJobId) {
        this.scheduleJobId = scheduleJobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public String getIsSync() {
        return isSync;
    }

    public void setIsSync(String isSync) {
        this.isSync = isSync;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "JobAndTrigger{" +
                "scheduleJobId=" + scheduleJobId +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", isDurable='" + isDurable + '\'' +
                ", isSync='" + isSync + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}


