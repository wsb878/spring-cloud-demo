package com.system.springcloud.provider.controller;

import com.system.springcloud.provider.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@Slf4j
@RefreshScope
@RestController
public class ProviderController {

    //@Value("${age}")
    private int age;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/getAge",method = RequestMethod.GET)
    public String getAge(@RequestParam String name) {

        log.info("Call spring-cloud-provider getAge parameter: {}", name);

        String res = name + "is " + age +"years old." + consumerService.helloWord(name);

        log.info("Call spring-cloud-provider getAge Parameter: {} Result: {}" ,name, res);
        return res;
    }

}
