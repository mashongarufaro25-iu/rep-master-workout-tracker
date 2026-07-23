package com.repmaster.repmaster.service;

import com.repmaster.repmaster.dto.LoginRequest;
import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Handles the business logic for user login.
 */
@Service
public class LoginService {

    /**
     * Repository responsible for storing users.
     */
    private final UserRepository userRepository;


    /**
     * Creates a LoginService with the required repository.
     *
     * @param userRepository Repository used to store users.
     */
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Checks whether a user can log in.
     *
     * @param  loginRequest user info from the LoginRequest form
     * @return Login result.
     */
    public String login(LoginRequest loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user == null) {
            return "Invalid username or password.";
        }

        if (loginRequest.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        }

        return "Invalid username or password.";
    }
}