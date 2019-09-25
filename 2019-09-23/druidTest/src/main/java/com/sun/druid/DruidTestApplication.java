package com.sun.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DruidTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidTestApplication.class,args);
    }
}
