package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 11:18
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableEurekaServer//开启eureka 该微服务作为服务端
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
