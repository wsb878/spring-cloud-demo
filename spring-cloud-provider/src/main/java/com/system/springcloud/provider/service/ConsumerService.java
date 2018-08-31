package com.system.springcloud.provider.service;

import com.system.springcloud.provider.hystrix.FeignServerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@FeignClient(value = "spring-cloud-consumer",fallbackFactory = FeignServerFactory.class)
public interface ConsumerService {

    @RequestMapping(value = "/helloWord",method = RequestMethod.GET)
    String helloWord(@RequestParam(value = "params") String params);

}
