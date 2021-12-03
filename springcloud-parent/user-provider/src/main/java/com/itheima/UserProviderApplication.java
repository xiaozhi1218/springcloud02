package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:45
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@MapperScan(basePackages = "com.itheima.dao")
@EnableEurekaClient//启用eureka client 该微服务就是一个eureka 的客户端。
//@EnableDiscoveryClient//开启注册 和服务发现
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class,args);
    }
}
