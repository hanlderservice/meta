package com.chenyu.meta.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by 10296 on 2023/2/27
 *
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "meta.swagger")
public class Swagger3Properties {


    /**
     * 是否启用Swagger
     */
    private boolean enable;
    /**
     * 扫描基础包
     */
    @Value("${meta.swagger.base.package}")
    private String basePackage;

    /**
     * 联系人邮箱
     */
    @Value("${meta.swagger.contact.email}")
    private String contactEmail;

    /**
     * 联系人名称
     */
    @Value("${meta.swagger.contact.name}")
    private String contactName;

    /**
     * 联系人网址
     */
    @Value("${meta.swagger.contact.url}")
    private String contactUrl;

    /**
     * 描述
     */
    private String description;

    /**
     * 标题
     */
    @Value("${meta.swagger.description.title}")
    private String title;

    /**
     * 网址
     */
    @Value("${meta.swagger.description.url}")
    private String url;

    /**
     * 版本
     */
    @Value("${meta.swagger.description.version}")
    private String version;
    /**
     * 自定义参数配置
     */
    private List<ParameterConfig> parameterConfig;

    /**
     * 自定义参数配置
     */

    public static class ParameterConfig {

        /**
         * 名称
         */
        private String name;

        /**
         * 描述
         */
        private String description;

        /**
         * 参数类型
         * header, cookie, body, query
         */
        private String type = "head";

        /**
         * 数据类型
         */
        private String dataType = "String";

        /**
         * 是否必填
         */
        private boolean required;

        /**
         * 默认值
         */
        private String defaultValue;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public boolean isRequired() {
            return required;
        }

        public void setRequired(boolean required) {
            this.required = required;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ParameterConfig> getParameterConfig() {
        return parameterConfig;
    }

    public void setParameterConfig(List<ParameterConfig> parameterConfig) {
        this.parameterConfig = parameterConfig;
    }
}



