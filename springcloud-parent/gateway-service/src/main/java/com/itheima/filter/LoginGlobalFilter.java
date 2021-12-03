package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * filter dofialter
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 12:02
 * @description 标题
 * @package com.itheima.filter
 */
@Component
public class LoginGlobalFilter implements GlobalFilter, Ordered {

    //自定义逻辑的判断实现的方法
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        //1.获取请求对象request
        ServerHttpRequest request = exchange.getRequest();
        //2.获取响应对象response
        ServerHttpResponse response = exchange.getResponse();
        //3.获取请求对象中参数名为token的值 获取第一个参数的值
        String value = request.getQueryParams().getFirst("token");
        //4.判断 是否为123456 如果是 说明登录了，就放行 如果不是，说明没有登录，拦截，直接返回。
        if("123456".equals(value)){
            return  chain.filter(exchange);//放行
        }
        response.setStatusCode(HttpStatus.UNAUTHORIZED);

        //拦截
        return response.setComplete();
    }

    //标识返回值越低 表示 过滤器的执行优先级越高
    @Override
    public int getOrder() {
        return -1;
    }
}
