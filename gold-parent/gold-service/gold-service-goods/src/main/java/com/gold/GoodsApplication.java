package com.gold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: xu.dm
 * @Date: 2020/4/10 13:07
 * @Version: 1.0
 * @Description: TODO
 **/

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.gold.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
