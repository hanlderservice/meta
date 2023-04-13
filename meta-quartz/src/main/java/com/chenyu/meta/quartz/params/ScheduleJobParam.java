package com.chenyu.meta.quartz.params;

import com.chenyu.meta.common.param.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("查询定时任务Param")
public class ScheduleJobParam extends BasePageParam {

    @ApiModelProperty(name = "任务名称")
    private String jobName;
    @ApiModelProperty(name = "任务组名")
    private String jobGroup;
    @ApiModelProperty(name = "任务状态")
    private String isDurable;


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

    @Override
    public String toString() {
        return "ScheduleJobParam{" +
                "jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", isDurable='" + isDurable + '\'' +
                '}';
    }


}
