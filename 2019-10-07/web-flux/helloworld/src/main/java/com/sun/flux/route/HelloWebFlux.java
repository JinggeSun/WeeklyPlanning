package com.sun.flux.route;

import com.sun.flux.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @ClassName HelloWebFlux
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Configuration
public class HelloWebFlux {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloHandler helloHandler){
        return RouterFunctions.route(
                RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN))
                ,helloHandler::hello);
    }

}
