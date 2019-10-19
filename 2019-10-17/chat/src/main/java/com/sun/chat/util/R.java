package com.sun.chat.util;

import lombok.Data;

/**
 * @ClassName R
 * @Description: 页面返回
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Data
public class R {

    private int code = 200;
    private String msg = "success";
    private Object data;

    public R(Object data){
        super();
        this.data = data;
    }

    public R(int code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    public R() {
        super();
    }
}
