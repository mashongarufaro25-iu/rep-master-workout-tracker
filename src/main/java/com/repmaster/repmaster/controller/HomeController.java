package com.repmaster.repmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController handles requests to the application's home page.
 *
 * This controller is used to demonstrate how Spring Boot receives
 * HTTP requests and sends responses back to the browser.
 *
 * @author Rufaro Mashonganyika
 */

@Controller//This class tells the Spring Boot that this class handles request from the browser
public class HomeController {

    /**
     * Redirects the user from the root URL
     * to the login page.
     *
     * @return Redirects to index.html
     */
    @GetMapping("/")
    public String home() {

        return "redirect:/index.html";

    }

}
