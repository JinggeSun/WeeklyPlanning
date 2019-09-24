package com.sun.cacheredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
//开启缓存
@EnableCaching
public class RedisConfig {

    //lettuce客户端
    @Autowired
    LettuceConnectionFactory connectionFactory;

    /**
     * 配置redis客户端
     * @return
     */
    @Bean
    @Primary
    public RedisTemplate<Object,Object> redisTemplate(){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();

        //连接
        redisTemplate.setConnectionFactory(connectionFactory);
        //替换默认序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = initJacksonSerializere();
        //设置新的序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * jackson21 序列化
     */
    private Jackson2JsonRedisSerializer<Object> initJacksonSerializere(){
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //日期
        om.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }

    /**
     * 缓存管理
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                //默认策略 未配置的key
                .cacheDefaults(redisConfig(60))
                //自定义 key 策略
                .withInitialCacheConfigurations(redisCacheConfigurationMap()).build();
    }

    private Map<String, RedisCacheConfiguration> redisCacheConfigurationMap(){
        Class<CacheNameEnum> cacheNameEnumClass = CacheNameEnum.class;
        final Enum<?>[] enums = cacheNameEnumClass.getEnumConstants();
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(100);
        for (Enum<?> e : enums) {
            CacheNameEnum cacheEnumer = (CacheNameEnum) e;
            redisCacheConfigurationMap.put(cacheEnumer.cacheName(), this.redisConfig(cacheEnumer.ttlSecond()));
        }
        return redisCacheConfigurationMap;
    }

    /**
     * 缓存配置
     * @param seconds
     * @return
     */
    private RedisCacheConfiguration redisConfig(Integer seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = initJacksonSerializere();
        RedisSerializationContext.SerializationPair<Object> objectSerializationPair = RedisSerializationContext
                .SerializationPair
                .fromSerializer(jackson2JsonRedisSerializer);

        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(objectSerializationPair)
                // 缓存ttl
                .entryTtl(Duration.ofSeconds(seconds));
    }


}
