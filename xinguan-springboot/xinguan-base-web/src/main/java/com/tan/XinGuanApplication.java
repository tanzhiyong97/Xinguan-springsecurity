package com.tan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@MapperScan("com.tan.system.mapper")
@EnableSwagger2 //开启swagger注解
@SpringBootApplication
public class XinGuanApplication {
    public static void main(String[] args){
        SpringApplication.run(XinGuanApplication.class, args);
    }
}
