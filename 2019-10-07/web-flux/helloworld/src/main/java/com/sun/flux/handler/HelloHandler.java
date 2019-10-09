package com.sun.flux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @ClassName HelloHandler
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .body(BodyInserters.fromObject("hello world"));
    }
}
