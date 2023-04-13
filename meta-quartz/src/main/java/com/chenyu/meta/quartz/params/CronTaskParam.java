package com.chenyu.meta.quartz.params;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("添加定时任务Param")
public class CronTaskParam  extends BaseParam {


    @ApiModelProperty(name = "任务Id")
    private String scheduleJobId;
    @ApiModelProperty(name = "任务名称")
    private String jobName;
    @ApiModelProperty(name = "任务组名")
    private String jobGroup;
    @ApiModelProperty(name = "任务状态")
    private String isDurable;
    @ApiModelProperty(name = "任务别名")
    private String aliasName;
    @ApiModelProperty(name = "任务全类名")
    private String jobClassName;
    @ApiModelProperty(name = "定时任务表达式")
    private String cronExpression;
    @ApiModelProperty(name = "任务状态")
    private String jobTrigger;
    @ApiModelProperty(name = "任务描述")
    private String jobDesc;

    public String getScheduleJobId() {
        return scheduleJobId;
    }

    public void setScheduleJobId(String scheduleJobId) {
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

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
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

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    @Override
    public String toString() {
        return "CronTaskParam{" +
                "scheduleJobId='" + scheduleJobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", isDurable='" + isDurable + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", jobTrigger='" + jobTrigger + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                '}';
    }

}
