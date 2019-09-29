package com.sun.idempotency.util;

import java.util.UUID;

/**
 * @ClassName RandomUtil
 * @Description: TODO
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
public class RandomUtil {


    public static String UUID32() {
        String str = UUID.randomUUID().toString();
        return str.replaceAll("-", "");
    }

    public static String UUID36() {
        return UUID.randomUUID().toString();
    }
}
