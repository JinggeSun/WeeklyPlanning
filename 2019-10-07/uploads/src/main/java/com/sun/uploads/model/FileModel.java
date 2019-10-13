package com.sun.uploads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@Slf4j
@NoArgsConstructor
@ToString
public class File implements Serializable {

    private Long id;
    private String name;
    private String md5;
    private String path;
    private Date uploadTime;



}
