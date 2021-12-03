package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:50
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //路径参数
    //根据ID 获取用户的数据

    @GetMapping("/{id}")
    public User findById(@PathVariable(name="id") Integer id){
        System.out.println("这个是18083===============");
        return userService.findById(id);
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable(name="id") Integer id){
        System.out.println("这个是18081===============");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.findById(id);
    }
}
