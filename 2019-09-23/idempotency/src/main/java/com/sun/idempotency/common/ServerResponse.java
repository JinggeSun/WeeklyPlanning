package com.sun.idempotency.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ServerResponse
 * @Description: 封装的返回实体 1,code,2,message,3,object data
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse implements Serializable {

    private Integer status;
    private String msg;
    private Object data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    //成功，只有返回码
    public static ServerResponse success() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static ServerResponse success(String msg) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static ServerResponse success(Object data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static ServerResponse success(String msg, Object data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static ServerResponse error(String msg) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static ServerResponse error(Object data) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), null, data);
    }

    public static ServerResponse error(String msg, Object data) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), msg, data);
    }

}
