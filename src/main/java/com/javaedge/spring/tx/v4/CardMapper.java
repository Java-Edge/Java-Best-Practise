package com.javaedge.spring.tx.v4;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Mapper
public interface CardMapper {
    @Insert("INSERT INTO `card`(`user_id`, `balance`) VALUES (#{userId}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveCard(Card card);
}
