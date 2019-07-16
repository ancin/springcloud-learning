/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ancin
 * @create 2019-07-15 18:16
 **/
@RestController
public class HelloController {



    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello() throws Exception {
       System.out.println("hello -service");
        return "======Hello World=====";
    }
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        System.out.println("hello "+name+"，this is first messge");
        return "hello "+name+"，this is first messge";
    }

    @GetMapping("/{id}")
    public Optional<String> findById(@PathVariable Long id) {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        System.out.println("#server uuid:"+uuid);
        return Optional.ofNullable(uuid);
    }

}
