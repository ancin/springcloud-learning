/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ancin
 * @create 2019-07-16 10:52
 **/
@RestController
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    /*@Autowired
    HelloRemote helloRemote;*/

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public String findById(@PathVariable Long id) {
        System.out.println("##id="+id);
        String uri = "http://HELLO-SERVICE/";
        return this.restTemplate.getForObject(uri+ id, String.class);
    }
    public String findByIdFallback(Long id){
        return "默认用户";
    }

    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String index(@PathVariable("name") String name) {
        String uri = "http://HELLO-SERVICE/hello?name=";
        System.out.println("client call.name="+name);
        return this.restTemplate.getForObject(uri+name, String.class);
    }
    public String helloFallback(String name){
        return "HELLO-callback";
    }


    @RequestMapping("/getUser/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String getUser(@PathVariable("name") String name) {
        String uri = "http://USER-SERVICE/getUser?name=";
        System.out.println("client call getUser name="+name);
        return this.restTemplate.getForObject(uri+name, String.class);
    }

}
