package com.sun.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName Stuent
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-07
 * @Version V1.0
 **/
@ApiModel("用户实体")
public class Stuent {
    @ApiModelProperty("用户 id")
    private int id;

    public Stuent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
