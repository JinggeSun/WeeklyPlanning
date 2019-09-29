package com.sun.idempotency.controller;

import com.sun.idempotency.annoation.IdempotencyAnnioation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName IdempotencyController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@RestController
public class IdempotencyController {

    @IdempotencyAnnioation
    @GetMapping("/index")
    public String index(){
        return "success";
    }
}
