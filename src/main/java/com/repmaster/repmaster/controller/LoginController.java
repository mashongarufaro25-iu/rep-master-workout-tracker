package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.dto.LoginRequest;
import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.service.LoginService;
import org.springframework.http.ResponseEntity;
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
     * Creates a LoginController.
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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        // Try to log in the user
        User user = loginService.login(loginRequest);

        // If login is correct, return the user
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        // If login fails, send an error message
        return ResponseEntity.badRequest().body("Invalid username or password.");

    }

}