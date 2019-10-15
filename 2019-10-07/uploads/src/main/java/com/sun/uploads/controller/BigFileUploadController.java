package com.sun.uploads.controller;

import com.sun.uploads.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName BigFileUploadController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@RestController
@RequestMapping("/bigFile")
@CrossOrigin
public class BigFileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/")
    public void upload(String name,
                       String md5,
                       Long size,
                       Integer chunks,
                       Integer chunk,
                       MultipartFile file) throws IOException {
        if (chunks != null && chunks != 0) {
            fileService.uploadWithBlock(name, md5,size,chunks,chunk,file);
        } else {
            fileService.upload(name, md5,file);
        }
    }
}
