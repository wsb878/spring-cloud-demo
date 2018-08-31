package com.system.springcloud.provider.hystrix;

import com.system.springcloud.provider.service.ConsumerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@Component
public class FeignServerFactory implements FallbackFactory<ConsumerService> {

    @Override
    public ConsumerService create(Throwable throwable) {
        return new ConsumerService() {
            @Override
            public String helloWord(@RequestParam(value = "params") String params) {
                return " hey man, weiwei is not here,come here and kill you ass.";
            }
        };
    }
}
