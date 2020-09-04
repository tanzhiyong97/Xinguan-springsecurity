package com.tan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tan.system.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("谭志勇", "http://www.tanzhiyong97.cn/", "tanzhiyong97@gmail.com");
        return new ApiInfoBuilder()
                .title("新冠物资管理系统 RESTful APIs")
                .description("后端：springboot+springSecurity+swagger  前端：vue+ElementUI")
                .termsOfServiceUrl("http://tanzhiyong97.cn")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
