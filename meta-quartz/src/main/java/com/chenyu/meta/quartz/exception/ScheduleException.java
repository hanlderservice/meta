package com.chenyu.meta.quartz.exception;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public class ScheduleException extends Exception {

    public ScheduleException(Throwable e) {
        super(e);
    }


    public ScheduleException(String message) {
        super(message);
    }


}
