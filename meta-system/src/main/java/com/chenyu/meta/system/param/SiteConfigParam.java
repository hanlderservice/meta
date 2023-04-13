package com.chenyu.meta.system.param;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("站点配置参数")
public class SiteConfigParam extends BaseParam {

    @ApiModelProperty(value = "站点名称", example = "")
    private String webSiteName;
    @ApiModelProperty(value = "站点logo", example = "站点logo")
    private String webSiteLogo;
    @ApiModelProperty(value = "站点主题", example = "站点主题")
    private String webSiteTheme;

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }

    public String getWebSiteLogo() {
        return webSiteLogo;
    }

    public void setWebSiteLogo(String webSiteLogo) {
        this.webSiteLogo = webSiteLogo;
    }

    public String getWebSiteTheme() {
        return webSiteTheme;
    }

    public void setWebSiteTheme(String webSiteTheme) {
        this.webSiteTheme = webSiteTheme;
    }
}
