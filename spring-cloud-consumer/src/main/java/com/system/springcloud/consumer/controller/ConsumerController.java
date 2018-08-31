package com.system.springcloud.consumer.controller;

import com.system.springcloud.consumer.services.FeignService;
import com.system.springcloud.consumer.services.RibbonService;
import lombok.extern.slf4j.Slf4j;
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
public class ConsumerController {

    @Autowired
    private FeignService feignService;

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping(value = "/infoForFeign",method = RequestMethod.GET)
    public String infoForFeign(@RequestParam String name) {
        log.info("Call spring-cloud-consumer infoForFeign");
        String res = feignService.getName(name);
        log.info("Call spring-cloud-consumer infoForFeign Result:{}",res);
        return res;
    }

    @RequestMapping(value = "/infoForRibbon",method = RequestMethod.GET)
    public String infoForRibbon(@RequestParam String name) {
        log.info("Call spring-cloud-consumer infoForRibbon");
        String res = ribbonService.getName(name);
        log.info("Call spring-cloud-consumer infoForRibbon Result:{}", res);
        return res;
    }

    @RequestMapping(value = "/helloWord")
    private String helloWord(String params) {
        log.info("Call spring-cloud-consumer infoForRibbon");
        String res = params + "hello word !";
        log.info("Call spring-cloud-consumer infoForRibbon Result:{}", res);
        return res;

    }

    /*@PostConstruct
    public void testSend() {
        new Thread(()->{

            while (true) {
                try {

                    infoForFeign();
                    infoForRibbon();
                    Thread.sleep(3);
                } catch (Exception e) {
                }
            }

        }).start();
    }*/

}
