package com.sun.uploads.controller;

import com.sun.uploads.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName QuickUploadController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@RestController
@RequestMapping("/quick")
//跨域配置
@CrossOrigin
public class QuickUploadController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public boolean upload(String md5) {
        return fileService.checkMd5(md5);
    }
}
