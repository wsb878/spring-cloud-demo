package com.system.springcloud.consumer.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@Component
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getNameFallback")
    public String getName(String name) {
        return restTemplate.getForObject("http://SPRING-CLOUD-PROVIDER/getAge?name="+name,String.class);
    }

    public String getNameFallback(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
