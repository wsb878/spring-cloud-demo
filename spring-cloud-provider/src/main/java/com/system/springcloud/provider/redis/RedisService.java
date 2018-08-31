package com.system.springcloud.provider.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@Slf4j
@Component
public class RedisService {

    /**
     * 操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * RedisTemplate，可以进行所有的操作
     */
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    public void set(String key, String value){
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        boolean bExistent = this.stringRedisTemplate.hasKey(key);
        if (bExistent) {
            log.warn("this key:{} is bExistent!",key);
        }else{
            ops.set(key, value);
        }
    }

    public String get(String key){
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key){
        this.stringRedisTemplate.delete(key);
    }

    public void sentinelSet(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String sentinelGet(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

}
