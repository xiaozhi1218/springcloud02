package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 09:56
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
public class RestConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    //bean注解 将restTemplate对象交给spring容器管理
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
