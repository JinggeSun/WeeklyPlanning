package com.sun.idempotency.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName IdempotencyAnnioation
 * @Description: 自定义注解，使用拦截器实现，当接收到注解时，代表要验证幂等性
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdempotencyAnnioation {
    //业务，不需要传入参数
}
