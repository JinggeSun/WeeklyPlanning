package com.sun.cacheredis.controller;

import com.sun.cacheredis.config.CaptchaCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private CaptchaCache captchaCache;

    @GetMapping("/put")
    public String putCode(){

        String code = "12324";
        captchaCache.put("myKey", code);

        return code;

    }


    /**
     * Get code string.
     *
     * @return the string
     */
    @GetMapping("/get")
    public String getCode(){

        return captchaCache.get("myKey");

    }


    /**
     * Expire.
     */
    @GetMapping("/exp")
    public void expire(){
        captchaCache.expire("myKey");
    }


}
