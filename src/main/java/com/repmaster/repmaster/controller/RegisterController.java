package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.dto.RegisterRequest;
import com.repmaster.repmaster.service.RegisterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles user registration requests.
 */
@RestController
@RequestMapping("/api")
public class RegisterController {

    /**
     * Service responsible for registering users.
     */
    private final RegisterService registerService;

    /**
     * Creates a RegisterController.
     *
     * @param registerService Service used for user registration.
     */
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    /**
     * Registers a new user.
     *
     * @param request Registration data received from the browser.
     * @return Registration result.
     */
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return registerService.register(request);

    }

}