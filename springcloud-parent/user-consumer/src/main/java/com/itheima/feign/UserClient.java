package com.itheima.feign;

import com.itheima.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 声明式的feign接口 用作替代restTemplate发送请求接收响应
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 08:53
 * @description 标题
 * @package com.itheima.feign
 */
//name 指定的是要发送到哪个微服务对应的名字
@FeignClient(name="user-provider",fallback = UserClientImpl.class,path = "/user")
//@RequestMapping("/user")
public interface UserClient {


    /**
     * 要求：
     *  1.接口的方法的返回值  一定要和 被调用方的controller的返回值一致
     *  2.接口的方法的参数类型 和参数个数 一定要和被调用方的controller的参数和个数一致。
     *  3.注解一定要加 比如：@PathVariable(name="id")  @requestParam(name="id") @requestBoby
     *  4.接口的方法的路径 一定要和被调用方的路径一致。
     */

    /**
     * 根据用户的ID 获取用户的信息（实际上是发送请求给微服务 获取数据）
     * @return
     */
    @GetMapping("/find/{id}")
    public User findById(@PathVariable(name="id") Integer id);

    @GetMapping("/findx")
    public User findByparam(@RequestParam(name="id") Integer id,@RequestParam(name="name")String name);

    @GetMapping("/add")
    public User addUser(@RequestBody User user);

}
