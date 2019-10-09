package com.sun.flux.curd.handler;

import com.sun.flux.curd.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StudentHandler
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Component
@Slf4j
public class StudentHandler {

    /**
     * 获取系统时间
     * @param request
     * @return
     */
    public Mono<ServerResponse> getTime(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("now is " + new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date())),String.class);

    }

    public Mono<ServerResponse> getStudent(ServerRequest request){
        List<Student> list = Arrays.asList(Student.builder().id("1").name("zhangsan").build(), Student.builder().id("2").name("lisi").build());
        return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(Flux.just(list), List.class);
    }


}
