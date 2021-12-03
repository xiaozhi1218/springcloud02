package com.itheima;

import com.itheima.config.DefaultRibbonConfig;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:55
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启用熔断器
//@RibbonClient(name = "user-provider",configuration = DefaultRibbonConfig.class )
@EnableFeignClients//启用feign客户端
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced//开启ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     *
     *
     * Logger.Level您可以为每个客户端配置的对象告诉Feign要记录多少。选择是：
     *
     * NONE，不记录（DEFAULT）。
     *
     * BASIC，仅记录请求方法和URL以及响应状态代码和执行时间。
     *
     * HEADERS，记录基本信息以及请求和响应标头。
     *
     * FULL，记录请求和响应的标题，正文和元数据。
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        //设置feign调用的级别 是Full
        return Logger.Level.FULL;
    }
}

