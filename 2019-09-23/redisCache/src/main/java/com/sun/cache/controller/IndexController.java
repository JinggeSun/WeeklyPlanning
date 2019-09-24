package com.sun.cache.controller;

import com.sun.cache.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;


    @GetMapping("/get")
    public String getIndex(String key){
        return indexService.getIndedx(key);
    }

    @GetMapping("/put")
    public String putIndex(String key,String value){
        return indexService.putIndedx(key,value);
    }

}
