package com.system.springcloud.provider.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring-cloud-demo
 *
 * @author ShuZhen email: muzhi@baofu.com  2017年12月15日 11点19分
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest  {

    @Autowired
    RedisService redisService;

    @Test
    public void redisSet() {

        redisService.set("KEY:AAA","AAA");
        log.info("====> Redis get Result {}",redisService.get("KEY:AAA"));

        redisService.sentinelSet("KEY:BBB","BBB");
        log.info("====> Redis sentinelGet Result {}",redisService.sentinelGet("KEY:BBB"));
    }
}
