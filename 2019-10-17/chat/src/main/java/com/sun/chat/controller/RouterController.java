package com.sun.chat.controller;

import com.sun.chat.entitiy.User;
import com.sun.chat.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName RouterController
 * @Description: 页面控制器
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Slf4j
@Controller
public class RouterController {

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestBody User user, HttpServletRequest request){
        Enumeration<String> ids = request.getSession().getAttributeNames();
        while (ids.hasMoreElements()){
            String id = ids.nextElement();
            if (request.getSession().getAttribute(id) instanceof  User){
                if (((User) request.getSession().getAttribute(id)).getName().equals(user.getName())) {
                    return new R(500, "该用户名已存在");
                }
            }
        }

        request.getSession().setAttribute(user.getId().toString(), user);
        log.info("session >> {}", request.getSession().getAttribute(user.getId().toString()));
        return new R();

    }

    @GetMapping("/{id}.chat")
    public String index(@PathVariable("id") Long id, HttpServletRequest request){
        Object user = request.getSession().getAttribute(id.toString());
        if (null == user){
            return "redirect:/";
        }
        return "index";
    }

}
