package com.sun.shiro.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @ClassName BaseAddEntity
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
abstract class BaseAddEntity<T extends  Model>  extends Model {

    /**
     * 创建日期 - 现在时表示主动创建
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @Past(message = "创建时间必须是过去时间")
    private Date gmtCreate;
}


