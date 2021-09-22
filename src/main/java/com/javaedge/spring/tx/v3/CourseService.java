package com.javaedge.spring.tx.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JavaEdge
 * @date 2021/11/23
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserCourseMapper userCourseMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void regCourse(int userId) throws Exception {
        userCourseMapper.saveUserCourse(userId, 1);
        courseMapper.addCourseNumber(1);
        throw new Exception("注册失败");
    }
}
