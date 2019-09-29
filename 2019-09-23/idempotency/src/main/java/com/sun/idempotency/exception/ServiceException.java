package com.sun.idempotency.exception;

import lombok.Data;

/**
 * @ClassName ServiceException
 * @Description: 自定义异常
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
public class ServiceException extends RuntimeException{

    private String code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg){
        super(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
