package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 黄重杨 on 2018/10/29.
 * ClassName: DemoController
 */
@CrossOrigin
@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo(){
        System.out.println("this is running on 9999 port");
    }
}
