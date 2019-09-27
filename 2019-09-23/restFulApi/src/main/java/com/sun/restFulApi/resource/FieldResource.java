package com.sun.restFulApi.resource;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class FieldResource {

    //实体对象
    private String resource;

    //字段
    private String field;

    //代码
    private String code;

    //具体信息
    private String message;
}
