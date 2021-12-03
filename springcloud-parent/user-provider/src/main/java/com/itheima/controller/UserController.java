package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public User findById(@PathVariable(name="id") Integer id, @RequestHeader(name="zhangsan") String value){
        System.out.println("获取到的值："+value);
        System.out.println("这个是18081===============");
        return userService.findById(id);
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable(name="id") Integer id){
        System.out.println("这个是18081===============");
        int i=1/0;
        return userService.findById(id);
    }
}
