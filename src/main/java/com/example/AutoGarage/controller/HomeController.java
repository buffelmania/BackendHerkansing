package com.example.AutoGarage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
//
//    @Controller
//    public class HelloController {
//        @GetMapping("/")
//        public @ResponseBody
//        String sayHello() {
//            return "Hello world";
//        }
//    }
//}

//    @GetMapping("/customers")
//    public String listCustomers(Model model) {
//        model.addAttribute("customers", customerServiceImpl.getAllCustomers());
//        return "customers";
//
//    }


//@Controller
//public static class HelloController {
//        @GetMapping("/")
//        public String sayHello() { return "index"; }
//    }
}
