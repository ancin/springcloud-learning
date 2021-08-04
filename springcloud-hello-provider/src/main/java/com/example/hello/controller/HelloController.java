/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.hello.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ancin
 * @create 2019-07-15 18:16
 **/
@RestController
public class HelloController {

    @Autowired
    protected RestTemplate restTemplate;


    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "findByNameFallback")
    public String hello(@RequestParam String name) {
        System.out.println("server:hello "+name+"，this is first messge");
        String uri = "http://USER-SERVICE/getUser?name=";
        System.out.println("client call.name="+name);
        String res = restTemplate.getForObject(uri+name, String.class);
        System.out.println("## get userInfo from userService message:"+res);
        return "hello "+name+"，this is first messge";
    }

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Optional<String> findById(@PathVariable Long id) {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        System.out.println("#server uuid:"+uuid);
        return Optional.ofNullable(uuid);
    }

    public String findByIdFallback(Long id){
        return "默认用户";
    }
    public String findByNameFallback(String name){
        return "默认用户";
    }

}
