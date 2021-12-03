package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:02
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试用  接收页面传递的请求 调用provder 获取用户的数据返回
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable(name="id")Integer id){

        //1.创建RestTemplate对象 交给spring容器管理

        //2.注入RestTemplate对象

        //3.使用restTemplate模拟浏览器发送GET请求给provider  获取到provider返回回来的JSON 将JSON转换成POJO 返回
        User userFromProvider = restTemplate.getForObject("http://localhost:8001/user/" + id, User.class);

        return userFromProvider;
    }
}
