package com.consul.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IHelloService
 * @author: ancin
 * @create: 2020-01-07 19:31
 * @Version 1.0
 **/
@FeignClient(value = "consul-provider")
public interface IHelloService {
    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "nice")
    String nice();
}
