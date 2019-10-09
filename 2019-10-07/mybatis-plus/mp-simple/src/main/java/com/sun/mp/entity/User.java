package com.sun.mp.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
