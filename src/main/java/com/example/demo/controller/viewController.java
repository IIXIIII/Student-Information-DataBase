package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {
    @GetMapping("/student/index")
    public String index(Model model) {
        model.addAttribute("title", "传递到的title");
        model.addAttribute("description", "传递的description");
        model.addAttribute("keyword", "传递的keyword");
        return "index"; // Thymeleaf will look for index.html in the templates folder
    }
}
