package com.sun.chat.controller;

import com.sun.chat.entitiy.User;
import com.sun.chat.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ChatController
 * @Description: 聊天ajax
 * @Author zcm
 * @Date 2019-10-19
 * @Version V1.0
 **/
@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {


    /**
     * 根据ID从session中获取用户信息
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/{id}")
    public R info(@PathVariable("id") String id, HttpServletRequest request){
        User user = new User();
        if (request.getSession().getAttribute(String.valueOf(id)) instanceof User){
            user = (User) request.getSession().getAttribute(id);
        }
        return new R(user);
    }



}
