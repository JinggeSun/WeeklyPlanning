package com.sun.idempotency.controller;

import com.sun.idempotency.common.ServerResponse;
import com.sun.idempotency.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description:  幂等性校验的控制器
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@RestController
public class IndexController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public ServerResponse token(){
        return tokenService.createToken();
    }

}
