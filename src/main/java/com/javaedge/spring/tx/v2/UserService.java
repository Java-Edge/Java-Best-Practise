package com.javaedge.spring.tx.v2;

import com.javaedge.spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    public void saveUser(String name) throws Exception {
        User user = new User();
        user.setName(name);
        userService.doSaveUser(user);
    }

    @Transactional
    private void doSaveUser(User user) {
        userMapper.saveUser(user);
        if ("JavaEdge".equals(user.getName())) {
            throw new RuntimeException("该用户已存在");
        }
    }
}
