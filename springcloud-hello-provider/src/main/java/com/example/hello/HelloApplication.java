/**
 * aa.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ancin
 * @create 2019-07-15 18:20
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
