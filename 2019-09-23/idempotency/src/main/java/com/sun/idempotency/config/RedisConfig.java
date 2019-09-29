package com.sun.idempotency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisConfig
 * @Description: redis的配置配，使用jedis作为客户端，使用jedispool
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@Configuration
public class RedisConfig {

    /**
     * pom为jedis，而不是Springbootjedis，所以要配置一下
     */
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Integer maxWait;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.timeout}")
    private int timeOut;


    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setMinIdle(minIdle);
        return new JedisPool(jedisPoolConfig, host, port, timeOut, password);
    }

}
