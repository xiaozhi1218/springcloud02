package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 12:21
 * @description 标题
 * @package com.itheima.filter
 */
@Component
public class MyParamGatewayFilterFactory  extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String name = config.getName();//头名
                String value = config.getValue();//头的值
                //传递头信息到微服中
                exchange.getRequest().mutate().header(name,value);
                System.out.println(name);
                System.out.println(value);
                return chain.filter(exchange);
            }
        };
    }
}
