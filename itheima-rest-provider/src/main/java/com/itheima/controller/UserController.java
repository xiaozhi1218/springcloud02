package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 09:58
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //根据用户的ID 获取用户的信息
    @GetMapping("/{id}")
    public User findById(@PathVariable(name="id")Integer id){
        //模拟从数据库中获取数据 返回
        return new User(id,"张三");
    }

}
