package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 10:58
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableDiscoveryClient//开启eureka的客户端
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
