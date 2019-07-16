/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ancin
 * @create 2019-07-16 18:07
 **/
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name) {
        System.out.println("server side:getUser "+name+"，this is from userService");
        return "get user from db: "+name;
    }
}
