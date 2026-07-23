package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.dto.LoginRequest;
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
     * @param loginRequest  entered by the user containing username and password.
     *
     * @return Confirmation message.
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        return loginService.login(loginRequest);

    }

}