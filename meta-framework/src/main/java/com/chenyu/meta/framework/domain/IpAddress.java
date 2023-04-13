package com.chenyu.meta.framework.domain;

import java.io.Serializable;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class IpAddress implements Serializable {

    private Long id;

    private String ipStart;

    private String ipEnd;

    private String area;

    private String operator;

    private Long ipStartNum;

    private Long ipEndNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getIpStartNum() {
        return ipStartNum;
    }

    public void setIpStartNum(Long ipStartNum) {
        this.ipStartNum = ipStartNum;
    }

    public Long getIpEndNum() {
        return ipEndNum;
    }

    public void setIpEndNum(Long ipEndNum) {
        this.ipEndNum = ipEndNum;
    }
}
