package com.itheima.controller;

import com.itheima.feign.UserClient;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 08:58
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping(value = "/feign")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    //根据ID获取用户的数据（要使用feign的方式来获取）
    @RequestMapping(value = "/{id}")
    public User queryById(@PathVariable(value = "id")Integer id){
        return userClient.findById(id);
    }
}
