package com.sun.cache.service;

import com.sun.cache.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexService {

    @Autowired
    RedisUtil redisUtil;
    static Map<String,Object> cacheMap = new HashMap<>();

    static {
        cacheMap.put("1",1);
        cacheMap.put("2",2);
    }


    public String putIndedx(String key, String value) {
      cacheMap.put(key,value);
      redisUtil.set(key,value);
      return "success";
    }

    public String getIndedx(String key) {
        String res = redisUtil.get(key);
        if (res== null){
            res =  "from server";
        }
        return res;
    }
}
