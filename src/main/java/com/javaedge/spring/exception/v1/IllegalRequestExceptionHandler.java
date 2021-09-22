package com.javaedge.spring.exception.v1;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理IllegalRequestException异常
 *
 * @author JavaEdge
 * @date 2021/10/24
 */
@RestControllerAdvice
public class IllegalRequestExceptionHandler {
    @ExceptionHandler(IllegalRequestException.class)
    @ResponseBody
    public String handle() {
        System.out.println("403");
        return "{\"code\": 403}";
    }
}
