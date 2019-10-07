package com.sun.swagger.controller;

import com.sun.swagger.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-07
 * @Version V1.0
 **/
@RestController
@RequestMapping("/index")
@Api(tags = "index接口", description = "返回index Rest API")
public class IndexController {

    @Autowired
    private
    IndexService indexService;

    @GetMapping("/list")
    @ApiOperation("返回所有的list")
    public List<String> list(){
        return indexService.list();
    }

}
