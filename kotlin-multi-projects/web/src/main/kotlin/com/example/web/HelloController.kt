package com.example.web

import com.example.core.HelloWorld
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @RequestMapping("/hello")
    fun hello(): String {
        val helloWorld = HelloWorld()
        return helloWorld.message()
    }
}
