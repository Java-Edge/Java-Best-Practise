package com.javaedge.spring.tx.v3;

import com.javaedge.spring.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `user`(`name`) VALUES (#{name})")
    void saveUser(User student);
}
