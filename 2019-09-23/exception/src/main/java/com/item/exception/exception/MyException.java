package com.item.exception.exception;

import com.item.exception.result.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义一个异常，接收code和msg两个参数
 */
public class MyException extends RuntimeException{

    private int code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }
}
