package com.sun.flux.curd.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @ClassName Student
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String address;
}
