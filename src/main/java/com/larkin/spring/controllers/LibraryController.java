package com.larkin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @GetMapping()
    public String index() {
        return "library/index";
    }
}
