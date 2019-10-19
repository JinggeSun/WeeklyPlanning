package com.sun.chat.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @ClassName HttpSessionConfig
 * @Description: 由于websocket的协议与Http协议是不同的，
 *  所以造成了无法直接拿到session。
 *  但是问题总是要解决的，不然这个websocket协议所用的场景也就没了
 *  重写modifyHandshake request可以获取httpSession
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Configuration
public class HttpSessionConfig extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession= (HttpSession) request.getHttpSession();
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
