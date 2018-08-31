package com.system.springcloud.consumer.hystrix;

import com.system.springcloud.consumer.services.FeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * spring-cloud-demo
 *
 * @author LanceWu email: wsb8878@gmail.com  2017年12月11日 10点58分
 */
@Component
public class FeignServerFactory implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public String getName(@RequestParam(value = "name") String name) {
                return "the server is not online,this is Feign hystrix result";
            }
        };
    }
}
