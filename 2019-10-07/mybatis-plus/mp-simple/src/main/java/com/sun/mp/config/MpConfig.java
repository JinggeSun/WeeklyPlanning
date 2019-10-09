package com.sun.mp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MpConfig
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
@Configuration
@MapperScan("com.sun.mp.mapper")
public class MpConfig {
}
