package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 14:51 2017/11/21
 * @Param:
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.example"})
@EnableScheduling//增加支持定时任务的注解
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
