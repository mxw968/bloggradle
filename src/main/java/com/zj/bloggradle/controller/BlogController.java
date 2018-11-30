package com.zj.bloggradle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
