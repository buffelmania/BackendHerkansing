package com.example.AutoGarage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    //Dit is de homepage voor alle rollen toegankelijk

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

}
