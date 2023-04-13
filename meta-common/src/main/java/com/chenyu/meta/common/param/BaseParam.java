package com.chenyu.meta.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@ApiModel("公共请求入参")
public class BaseParam {

    /**
     * ID
     */
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
