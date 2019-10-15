package com.sun.uploads.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sun.uploads.util.LogUtil.logToFile;

/**
 * @ClassName TestExceptionController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@RestController
@RequestMapping("/ex")
public class TestExceptionController {

    /**
     * 测试日志切面
     * @return
     */
    @GetMapping("/aspect")
    public int aspect() {
        int i = 1 / 0;
        return i;
    }

    /**
     * 测试日志util
     */
    @GetMapping("/util")
    public void util() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            logToFile(e);
        }
    }
}
