package com.example.AutoGarage.controller;

import com.example.AutoGarage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String allAccess() {
        return testService.generatePublicContent();
    }

    @GetMapping("/mech")
    public String userAccess() {
        return testService.generateUserContent();
    }

    @GetMapping("/mod")
    public String moderatorAccess() {
        return testService.generateModContent();
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return testService.generateAdminContent();
    }
}
