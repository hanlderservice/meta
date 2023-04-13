package com.chenyu.meta.adapter.domain;

/**
 * Create by 10296 on 2023/3/8
 *
 * @Description:
 */
public class DesensitizeAttrDefDto {

    private String name;
    private String code;
    private String type;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DesensitizeAttrDefDto{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
