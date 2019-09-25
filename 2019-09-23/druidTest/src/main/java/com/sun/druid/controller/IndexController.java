package com.sun.druid.controller;

import com.sun.druid.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    public List<Map<String,Object>> getIndex(){
        return indexService.getAllData();
    }
}
