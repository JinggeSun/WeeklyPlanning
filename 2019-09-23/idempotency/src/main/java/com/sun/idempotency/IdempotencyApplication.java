package com.sun.idempotency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
public class IdempotencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdempotencyApplication.class,args);
    }
}
