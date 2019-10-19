package com.sun.chat.service;

import com.sun.chat.entitiy.Message;
import com.sun.chat.entitiy.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName ChatSessionService
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-19
 * @Version V1.0
 **/
public interface ChatSessionService {

    /**
     * 推送消息
     * @param fromId
     * @param toId
     * @param message
     * @param session
     */
    void pushMessage(String fromId, String toId, String message, HttpSession session);

    /**
     * 在线用户列表
     * @param session
     * @return
     */
    List<User> oneLineList(HttpSession session);

    /**
     * 公共消息内容
     * @param session
     * @return
     */
    List<Message> commonList(HttpSession session);

    /**
     * 特定消息
     * @param fromId
     * @param toId
     * @param session
     * @return
     */
    List<Message> selfList(String fromId,String toId, HttpSession session);

}
