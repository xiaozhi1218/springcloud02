package com.itheima.controller;

import com.itheima.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:57
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultMyFallback")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 使用来测试  使用restTemplate发送请求给provider 获取用户的数据 返回给前端
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    //@HystrixCommand(fallbackMethod ="findByIdDefault")
    @HystrixCommand
    public User findById(@PathVariable(value = "id") Integer id) {
        //1.调用restTemplate的方法 远程调用provider 获取用户的数据
        //User user = restTemplate.getForObject("http://localhost:18081/user/" + id, User.class);

        //动态的从eureka server中获取服务名对应的IP和端口
        //List<ServiceInstance> instances = discoveryClient.getInstances("USER-PROVIDER");
        //ServiceInstance serviceInstance = instances.get(0);
        //User user = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id, User.class);


        //使用原生的restTemplate
        User user = restTemplate.getForObject("http://USER-PROVIDER/user/" + id, User.class);
        //如是使用feign


        return user;
    }

    //controller

    //controller

    //controller


    //需要返回一个默认的值（写一个兜底的方法） 备胎
    //要求  方法的返回值和上边的方法的返回值一致，方法的参数类型和个数 要和上边的方法的参数类型和个数保持一致
   public User findByIdDefault(Integer id){
        User user = new User();
        user.setId(1);
        user.setName("匿名用户");
        return user;
    }

    //创建一个全局默认的兜底的方法 方法 一定不能有参数
    public User defaultMyFallback(){
        User user = new User();
        user.setId(1);
        user.setName("匿名用户全局默认值");
        return user;
    }
}
