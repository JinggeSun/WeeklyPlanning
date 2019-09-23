package com.item.exception.result;

public enum ResultEnum {

    SUCCESS_RES(1,"success"),
    FAILEUE_RES(-1,"failure"),
    ;

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
