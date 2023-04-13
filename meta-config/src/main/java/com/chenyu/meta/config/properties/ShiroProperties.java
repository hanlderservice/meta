package com.chenyu.meta.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by 10296 on 2023/2/27
 *
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "meta.shiro")
public class ShiroProperties {


    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 路径权限配置
     */
    private String filterChainDefinitions;
    /**
     * 设置无需权限路径集合
     */
    private List<String[]> anon;
    /**
     * 权限配置集合
     */
    @NestedConfigurationProperty
    private List<ShiroPermissionProperties> permission;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public List<String[]> getAnon() {
        return anon;
    }

    public void setAnon(List<String[]> anon) {
        this.anon = anon;
    }

    public List<ShiroPermissionProperties> getPermission() {
        return permission;
    }

    public void setPermission(List<ShiroPermissionProperties> permission) {
        this.permission = permission;
    }


    public class ShiroPermissionProperties {

        /**
         * 路径
         */
        private String url;
        /**
         * 路径数组
         */
        private String[] urls;

        /**
         * 权限
         */
        private String permission;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String[] getUrls() {
            return urls;
        }

        public void setUrls(String[] urls) {
            this.urls = urls;
        }

        public String getPermission() {
            return permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }
    }




}
