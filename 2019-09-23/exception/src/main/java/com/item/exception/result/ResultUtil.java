package com.item.exception.result;

import java.util.Map;

public class ResultUtil {

    public static ResultData exception(int code,String msg){
        return new ResultData(code,msg,null);
    }

    public static ResultData success(Map<String,Object> map){
        return new ResultData(ResultEnum.SUCCESS_RES.getCode(),ResultEnum.SUCCESS_RES.getMsg(),map);
    }
}
