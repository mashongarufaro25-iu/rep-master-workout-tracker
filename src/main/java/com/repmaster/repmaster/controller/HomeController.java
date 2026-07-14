package com.repmaster.repmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//This class tells the Spring Boot that this class handles request from the browser
public class HomeController {

    @GetMapping("/")// allows the application to run
    public String home(){   // Method executed by the browser
        return "Hello RepMaster";
    }

}
