package com.item.exception.result;

import java.util.Map;

/**
 * Web接口返回类
 */
public class ResultData {

    private int id;
    private String msg;
    private Map<String,Object> data;

    public ResultData(int id, String msg, Map<String, Object> data) {
        this.id = id;
        this.msg = msg;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
