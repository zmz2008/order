package com.meipingmi.domain.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/20-14:28
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 方法需要有ApiOperation注解才能生存接口文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 默认 api所在的package 都生成
                .apis(RequestHandlerSelectors.basePackage("com.meipingmi.domain.order"))
                // 页面风格
                .paths(PathSelectors.any())
                // 运行并初始化相关内容
                .build().apiInfo(
                        new ApiInfoBuilder()
                                .title("Swagger2 接口测试")
                                .version("2.0")
                                .build()
                );
    }
}
