package com.item.exception.controller;

import com.item.exception.exception.MyException;
import com.item.exception.result.ResultData;
import com.item.exception.result.ResultEnum;
import com.item.exception.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping("/index")
    public ResultData getIndex(int id) throws MyException {
        if (id == 0) {
            throw new MyException(ResultEnum.FAILEUE_RES);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data","success");
        return ResultUtil.success(map);
    }
}
