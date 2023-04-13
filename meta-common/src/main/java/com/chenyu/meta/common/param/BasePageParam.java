package com.chenyu.meta.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@ApiModel("带有分页的公共请求入参")
public class BasePageParam extends BaseParam {

    @ApiModelProperty(name = "当前页面", value = "1", example = "1")
    private int pageIndex;
    @ApiModelProperty(name = "每页大小", value = "20", example = "20")
    private int pageSize;

    public int getPageIndex() {
        return (pageIndex - 1) * pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BasePageParam{" +
                "pageIndex='" + pageIndex + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }


}
