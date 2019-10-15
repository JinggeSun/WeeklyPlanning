package com.sun.uploads.controller;

import com.sun.uploads.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileUploadController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@RestController
@RequestMapping("/file")
//跨域配置
@CrossOrigin
public class FileUploadController {

    @Autowired
    private
    FileService fileService;

    @PostMapping("/single")
    public void upload(MultipartFile file) throws Exception{
        String name = file.getOriginalFilename();
        System.out.println(name);
        fileService.upload(name,"",file);
    }

}
