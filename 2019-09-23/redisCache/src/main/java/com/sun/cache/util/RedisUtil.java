package com.sun.cache.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {

    @Autowired
    JedisPool jedisPool;

    /**
     * 获取
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取
     * @param key
     * @param value
     * @return
     */
    public void set(String key,String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }


    private void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis = null;
        }
    }


}
