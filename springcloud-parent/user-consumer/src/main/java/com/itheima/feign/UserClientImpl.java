package com.itheima.feign;

import com.itheima.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/13 09:52
 * @description 标题
 * @package com.itheima.feign
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("feign集成hystrinx的默认的兜底的数据值名字");
        return user;
    }

    @Override
    public User findByparam(Integer id, String name) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
