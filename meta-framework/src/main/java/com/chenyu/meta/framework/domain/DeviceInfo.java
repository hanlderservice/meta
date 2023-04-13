package com.chenyu.meta.framework.domain;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class DeviceInfo {

    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备型号
     */
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
