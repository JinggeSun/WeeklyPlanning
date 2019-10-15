package com.sun.uploads.config;

import com.sun.uploads.UploadsApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UploadConfig
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Configuration
public class UploadConfig {

    /**
     * 上传路径
     */
    public static String path;

    @Value("${upload.path}")
    public void setPath(String path){
        UploadConfig.path = path;
    }



}
