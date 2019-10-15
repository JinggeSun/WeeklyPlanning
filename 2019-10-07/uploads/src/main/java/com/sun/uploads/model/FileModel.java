package com.sun.uploads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName File
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileModel implements Serializable {

    private Long id;
    private String name;
    private String md5;
    private String path;
    private Date uploadTime;


    public FileModel(String name, String md5, String path, Date date) {

        this.name = name;
        this.md5 = md5;
        this.path = path;
        this.uploadTime = date;
    }
}
