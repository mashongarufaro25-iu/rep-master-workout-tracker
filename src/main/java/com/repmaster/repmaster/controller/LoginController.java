package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.service.LoginService;
import org.springframework.web.bind.annotation.*;

/**
 * Handles login requests sent from the frontend.
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    /**
     * Service responsible for handling login logic.
     */
    private final LoginService loginService;

    /**
     * Creates a LoginController with the required LoginService.
     *
     * @param loginService The service that processes login requests.
     */
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * Receives login information from the frontend.
     *
     * @param username Username entered by the user.
     * @param password Password entered by the user.
     * @return Confirmation message.
     */
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        return loginService.login(username, password);

    }

}