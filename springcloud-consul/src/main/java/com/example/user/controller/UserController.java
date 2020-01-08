/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ancin
 * @create 2019-07-16 18:07
 **/
@RestController

public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "test")
    public String test(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            System.out.println("service:"+s);
        }
        return "hello spring cloud!";
    }

    @GetMapping(value = "nice")
    public String nice(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            System.out.println("gogogo" + s);
        }
        return "nice to meet you!";
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name) {
        System.out.println("server side:getUser "+name+"，this is from userService");
        return "get user from db: "+name;
    }
}
