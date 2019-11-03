package com.example.tingfeng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.example.tingfeng.controller
 * @Description
 * @Author tingfeng
 * @Date 2019/11/4
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello(){
        return "嗨，你好😊。";
    }
}
