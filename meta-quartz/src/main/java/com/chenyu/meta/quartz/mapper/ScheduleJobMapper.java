package com.chenyu.meta.quartz.mapper;

import com.chenyu.meta.quartz.entity.JobAndTrigger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description: 定时任务管理 mapper
 */
@Repository
public interface ScheduleJobMapper {
    /**
     * 查询定时任务列表
     *
     * @param pageParam
     * @return
     */
    List<JobAndTrigger> qryJobList(Map<String, Object> pageParam);

    /**
     * 添加定时任务
     *
     * @param pageParam
     * @return
     */
    int addScheduleJob(Map<String, Object> pageParam);

    /**
     * 修改定时任务
     *
     * @param pageParam
     * @return
     */
    int updateScheduleJob(Map<String, Object> pageParam);


}

