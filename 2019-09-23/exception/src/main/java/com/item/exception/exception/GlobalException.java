package com.item.exception.exception;

import com.item.exception.result.ResultData;
import com.item.exception.result.ResultEnum;
import com.item.exception.result.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = MyException.class)
    public ResultData handerData (MyException e) {
        return ResultUtil.exception(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value=Exception.class)
    public ResultData handler(Exception e){

        if (e instanceof MyException){
            MyException m = (MyException) e;
            return ResultUtil.exception(m.getCode(),m.getMessage());
        }
        return ResultUtil.exception(-1,e.getMessage());
    }

}
