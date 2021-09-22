package com.javaedge.spring.tx.v3;

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

    @Autowired
    private CourseService courseService;

    public void doSaveUser(User user) {
        userMapper.saveUser(user);
        if ("JavaEdge".equals(user.getName())) {
            throw new RuntimeException("该用户已存在");
        }
    }

    // 外层事务
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(String name) throws Exception {
        User user = new User();
        user.setId(1);
        user.setName(name);

        userService.doSaveUser(user);
        try {
            // 嵌套的内层事务
            courseService.regCourse(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
