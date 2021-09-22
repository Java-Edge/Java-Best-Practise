package com.javaedge.spring.tx.v1;

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

    @Transactional(rollbackFor = Exception.class)
    public void saveUser(String name) throws Exception {
        User user = new User();
        user.setName(name);
        userMapper.saveUser(user);
        if ("JavaEdge".equals(user.getName())) {
            throw new Exception("用户已存在");
        }
    }
}
