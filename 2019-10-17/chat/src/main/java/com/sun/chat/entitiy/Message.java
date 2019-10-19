package com.sun.chat.entitiy;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Message
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-18
 * @Version V1.0
 **/
@Data
public class Message implements Serializable {

    private User fromUser;
    /**
     * 消息接收者：
     *      如果是私有（向指定窗口推送），to即为接受者User对象
     *      如果是公共消息（群组聊天），to设为null
     */
    private User toUser;
    private String message;
    private String time;
    private Long online;
    public void setMessage(String message) {
        this.message = message == null ? "" : message.replaceAll("\r\n|\r|\n", "");
    }

}
