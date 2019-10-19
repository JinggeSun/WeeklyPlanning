package com.sun.chat.entitiy;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private String avatar;

    public void setName(String name) {
        this.name = name.trim();
    }
}
