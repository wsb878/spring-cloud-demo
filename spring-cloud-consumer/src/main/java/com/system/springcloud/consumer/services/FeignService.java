package com.system.springcloud.consumer.services;

import com.system.springcloud.consumer.hystrix.FeignServerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *@author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@FeignClient(value = "spring-cloud-provider",fallbackFactory = FeignServerFactory.class)
public interface FeignService {

    @RequestMapping(value = "/getAge",method = RequestMethod.GET)
    String getName(@RequestParam(value = "name") String name);

}
