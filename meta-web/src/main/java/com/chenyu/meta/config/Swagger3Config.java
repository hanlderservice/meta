package com.chenyu.meta.config;

import com.chenyu.meta.config.properties.Swagger3Properties;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import io.swagger.annotations.Api;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Create by 10296 on 2023/2/27
 *
 * @Description:
 */

@Configuration
@EnableOpenApi
public class Swagger3Config {

    public static final Logger LOGGER = LoggerFactory.getLogger(Swagger3Config.class);

    @Autowired
    private Swagger3Properties swagger3Properties;

    /*扫描多个包时，包路径拆分*/
    public static final String SPLIT_COMMA = ",";
    /*扫描多包时，包路径的拆分;*/
    public static final String SPLIT_SEMICOLON = ";";
    /**
     * Swagger3 忽略参数类型
     */
    private Class<?>[] ignoredParameterTypes = new Class[]{
            ServletRequest.class,
            ServletResponse.class,
            HttpServletRequest.class,
            HttpServletResponse.class,
            HttpSession.class,
            ApiIgnore.class
    };

    @Bean
    public Docket createRestApi() {

        String[] basePackages = getBasePackages();
        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).select();
        //如果扫描的包为空，则默认扫描类上有@Api注解的类
        if (ArrayUtils.isEmpty(basePackages)) {
            apiSelectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(Api.class));

        } else {
            //扫描指定的包
            apiSelectorBuilder.apis(basePackage(basePackages));
        }


        Docket docket = apiSelectorBuilder.paths(PathSelectors.any())
                .build()
                .enable(swagger3Properties.isEnable())
                .ignoredParameterTypes(ignoredParameterTypes)
                .globalRequestParameters(getRequestParameters())
                .globalResponses(HttpMethod.GET, getGlobalResponseMessage());

        return docket;
    }


    /**
     * 添加额外参数
     *
     * @return
     */
    private List<RequestParameter> getRequestParameters() {
        // 获取自定义参数配置
        List<Swagger3Properties.ParameterConfig> parameterConfig = swagger3Properties.getParameterConfig();
        if (CollectionUtils.isEmpty(parameterConfig)) {
            return null;
        }
        List<RequestParameter> parameters = new ArrayList<>();
        parameterConfig.forEach(parameter -> {
                    // 设置自定义参数
                    parameters.add(
                            new RequestParameterBuilder().name(parameter.getName())
                                    .description(parameter.getDescription())
                                    .required(parameter.isRequired())
                                    .in(ParameterType.QUERY)
                                    .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                                    .build()

                    );

                }
        );


        return parameters;

    }

    /**
     * 指定包
     *
     * @param basePackages
     * @return
     */
    private Predicate<RequestHandler> basePackage(String[] basePackages) {
        return input -> declaringClass(input).transform(handlerPackage(basePackages)).or(true);

    }

    private Function<Class<?>, Boolean> handlerPackage(String[] basePackages) {
        return input -> {

            for (String strPackage : basePackages) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };

    }

    @SuppressWarnings("deprecation")
    private Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

    /**
     * 获取apiInfo
     *
     * @return
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title(swagger3Properties.getTitle())
                .description(swagger3Properties.getDescription())
                .termsOfServiceUrl(swagger3Properties.getUrl())
                .contact(new Contact(swagger3Properties.getContactName(), swagger3Properties.getContactUrl(), swagger3Properties.getContactEmail()))
                .version(swagger3Properties.getVersion())
                .build();
    }

    /**
     * 获取扫描的包
     *
     * @return
     */
    private String[] getBasePackages() {

        LOGGER.info(">>>>>>>>>>>>>swagger3Properties: " + swagger3Properties);
        String[] basePackages = null;

        //获取包
        String basePackage = swagger3Properties.getBasePackage();
        if (StringUtils.isEmpty(basePackage)) {
            throw new RuntimeException("Swagger3  basePackage 不能为空！");
        }
        if (basePackage.contains(SPLIT_COMMA)) {
            basePackages = basePackage.split(SPLIT_COMMA);
        } else if (basePackage.contains(SPLIT_SEMICOLON)) {
            basePackages = basePackage.split(SPLIT_SEMICOLON);
        }
        LOGGER.info("swagger 3  scan basePackages:" + Arrays.toString(basePackages));

        return basePackages;

    }

    private List<Response> getGlobalResponseMessage() {

        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("404").description("找不到资源").build());
        return responseList;
    }

}
