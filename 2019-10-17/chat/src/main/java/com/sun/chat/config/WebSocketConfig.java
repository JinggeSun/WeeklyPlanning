package com.sun.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName WebSocketConfig
 * @Description: websocket 配置，启用websocket
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Configuration
public class WebSocketConfig {

    /**
     * 启用websocket
     * @return
     */
    @Bean
    public ServerEndpointExporter endpointExporter(){
        return new ServerEndpointExporter();
    }
}
