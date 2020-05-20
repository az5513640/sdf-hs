package com.sdf.demo;

import com.sdf.demo.constant.SwaggerConstant;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwaggerConfig
 * @Description: TODO
 * @Author ShuDingfeng
 * @createDate 2020-04-21-18:08
 * @Version 1.0
 **/

@Component
@Slf4j
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
//@Data
@Setter
public class SwaggerConfig {

    private String title;

    private String description;

    private String version;

    private String termsOfServiceUrl;

    private String name;

    private String url;

    private String email;

    private List<Parameter> addHeader(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder.name(SwaggerConstant.SWAGGER_NAME).description("swaggerName").modelRef(new ModelRef("String")).parameterType("header").required(true).build();
        parameters.add(parameterBuilder.build());
        parameterBuilder.name(SwaggerConstant.SWAGGER_CODE).description("swaggerCode").modelRef(new ModelRef("String")).parameterType("header").required(true).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }

    /**
     * api文档的详细信息函数,注意这里的注解引用的是哪个
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }

    /**
     * 通讯录在线API
     */
    @Bean
    public Docket sdfDemoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sdf hsTest-demo of sdf_demo")
                .select()
                //此包路径下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.sdf.demo.controller"))
                //选择那些路径和api会生成document
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .globalOperationParameters(addHeader())//所有swager请求添加请求头
                .apiInfo(apiInfo());
    }
}
