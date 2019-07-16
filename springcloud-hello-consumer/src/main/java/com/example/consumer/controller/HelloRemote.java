/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ancin
 * @create 2019-07-16 11:21
 **/
//@FeignClient(name= "hello-service")
public interface  HelloRemote {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
