package com.sun.flux.curd.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Man
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Man implements Serializable {

    private String id;
    private String name;
    private int age;
    private String phone;

}
