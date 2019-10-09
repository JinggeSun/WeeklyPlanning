package com.sun.flux.curd.route;

import com.sun.flux.curd.handler.StudentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * @ClassName StudentRoute
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Configuration
public class StudentRoute {

    @Autowired
    private
    StudentHandler studentHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return RouterFunctions.route(GET("/time"), req -> studentHandler.getTime(req))
                .andRoute(GET("/getStus"), studentHandler::getStudent);
    }

}
