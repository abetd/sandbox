package com.example.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hogehoge")
    public String helloworld() {
        return "Hello World.";
    }
}
