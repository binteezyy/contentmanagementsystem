package com.ppt.contentmanagementsystem.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/api")
    public String index() {
        return "Greeting from Spring Boot! This is a REST Controller end point";
    }
}
