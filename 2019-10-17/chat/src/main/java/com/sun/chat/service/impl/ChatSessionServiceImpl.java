package com.sun.chat.service.impl;

import com.sun.chat.common.Constant;
import com.sun.chat.entitiy.Message;
import com.sun.chat.entitiy.User;
import com.sun.chat.service.ChatSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * @ClassName ChatSessionServiceImpl
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-19
 * @Version V1.0
 **/
@Slf4j
@Service
public class ChatSessionServiceImpl implements ChatSessionService {
    @Override
    public void pushMessage(String fromId, String toId, String message, HttpSession session) {

        Object user = session.getAttribute(fromId);
        if (user instanceof User){

            Message entity = new Message();
            entity.setMessage(message);
            entity.setFromUser((User) user);
            entity.setTime(CoreUtil.fromat(new Date()));
            if (toId != null){

                Object to = session.getAttribute(toId);
                if (to instanceof  User){
                    entity.setToUser((User) to);
                }

                //给这个用户推送消息
                push(entity, Constant.CHAT_FROM_PREFIX+fromId+Constant.CHAT_TO_PREFIX+toId,session);

            }else {
                entity.setToUser(null);
                push(entity,Constant.CHAT_COMMON_PREFIX+fromId,session);
            }

        }



    }

    private void push(Message entity, String key, HttpSession session) {
        //这里按照 PREFIX_ID 格式，作为KEY储存消息记录
        //但一个用户可能推送很多消息，VALUE应该是数组
        List<Message> list = new ArrayList<>();
        Object msg = session.getAttribute(key);
        if (msg == null) {
            //第一次推送消息
            list.add(entity);
        } else {
            //第n次推送消息
            if (msg instanceof List) {
                list = (List<Message>) msg;
                list.add(entity);
            }
        }
        session.setAttribute(key, list);
    }

    @Override
    public List<User> onlineList(HttpSession session) {
        List<User> list = new ArrayList<>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            if (session.getAttribute(id) instanceof User) {
                list.add((User) session.getAttribute(id));
            }
        }
        return list;
    }

    @Override
    public List<Message> commonList(HttpSession session) {
        List<Message> list = new ArrayList<>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            //指定前缀标识
            if (id.startsWith(Constant.CHAT_COMMON_PREFIX)) {
                Object attribute = session.getAttribute(id);
                if (attribute instanceof List) {
                    List<Message> data = (List<Message>) attribute;
                    list.addAll(data);
                    CoreUtil.push(list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Message> selfList(String fromId, String toId, HttpSession session) {
        List<Message> list = new ArrayList<>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            //指定前缀标识
            if (id.startsWith(Constant.CHAT_FROM_PREFIX) || id.indexOf(Constant.CHAT_TO_PREFIX) > 0) {
                Object attribute = session.getAttribute(id);
                if (attribute instanceof List) {
                    list = (List<Message>) attribute;
                }
            }
        }
        return list;
    }
}
