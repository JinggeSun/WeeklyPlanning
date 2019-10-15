package com.sun.uploads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String testThymeleaf(ModelMap modelMap){
        return "index";
    }

}
