package com.tan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过environment.acceptsProfiles判断当前所属环境是否是我们设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(profiles);

        System.out.println(flag+" "+profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //enable是否启动swagger，如果是false，那么游览器中不能启动swagger-ui
                .enable(flag)
                //select，apis， build等这三个是一连串的
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tan.system"))  //指定提供接口所在的基包
                .build();
    }

    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("谭志勇", "http://www.tanzhiyong97.cn/", "tanzhiyong97@gmail.com");
        return new ApiInfo(
                "谭志勇的 Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
