package com.sun.swagger.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName SwaggerConfig
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-07
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //Springfox 提供了一个 Docket 对象，让我们可以灵活的配置 Swagger 的各项属性
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("cn.sun.swagger.controller"))
                .paths(Predicates.or(PathSelectors.ant("/user/add"),
                        PathSelectors.ant("/user/find/*")))
                .build();
    }

}
