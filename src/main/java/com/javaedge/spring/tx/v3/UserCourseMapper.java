package com.javaedge.spring.tx.v3;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Mapper
public interface UserCourseMapper {
    @Insert("INSERT INTO `user_course`(`user_id`, `course_id`) VALUES (#{userId}, #{courseId})")
    void saveUserCourse(@Param("userId") Integer userId, @Param("courseId") Integer courseId);
}
