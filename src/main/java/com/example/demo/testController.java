package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @GetMapping("/hello")
    public List<String> hello(){
        return List.of("hello", "world");
    }
}
