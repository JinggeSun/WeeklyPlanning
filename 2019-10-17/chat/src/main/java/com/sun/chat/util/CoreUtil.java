package com.sun.chat.util;

import com.sun.chat.entitiy.Message;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CoreUtil
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-19
 * @Version V1.0
 **/
public class CoreUtil {

    /**
     * format date
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 按照时间顺序向List中push数据
     *
     * @param list
     */
    public static void push(List<Message> list) {
        list.sort(Comparator.comparing(Message::getTime));
    }

}
