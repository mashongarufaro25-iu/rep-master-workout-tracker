package com.repmaster.repmaster.service;

import com.repmaster.repmaster.dto.RegisterRequest;
import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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
     * Encrypts passwords before storing them.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Creates a RegisterService.
     *
     * @param userRepository Repository for user data.
     * @param passwordEncoder Used to encrypt user passwords.
     */
    public RegisterService(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }



    /**
     * Registers a new user.
     *
     * @param request Registration details received from the client.
     * @return Confirmation message.
     */
    public String register(RegisterRequest request) {


        // Check if the username already exists
        User existingUser = userRepository.findByUsername(request.getUsername());

        if (existingUser != null) {

            return "Username already exists.";

        }

        // Check if the email already exists
        User existingEmail = userRepository.findByEmail(request.getEmail());

        if (existingEmail != null) {

            return "Email already exists.";

        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "Registration successful!";
    }

}