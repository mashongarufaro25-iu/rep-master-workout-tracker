package com.repmaster.repmaster.service;

import com.repmaster.repmaster.dto.RegisterRequest;
import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Handles user registration.
 */
@Service
public class RegisterService {
    /**
     * Repository used to save users.
     */
    private final UserRepository userRepository;

    /**
     * Creates a RegisterService.
     *
     * @param userRepository Repository for user data.
     */
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a new user.
     *
     * @param request Registration details received from the client.
     * @return Confirmation message.
     */
    public String register(RegisterRequest request) {

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "Registration successful!";
    }

}