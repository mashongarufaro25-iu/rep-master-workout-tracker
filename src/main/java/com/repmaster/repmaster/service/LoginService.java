package com.repmaster.repmaster.service;

import com.repmaster.repmaster.dto.LoginRequest;
import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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
     * Compares encrypted passwords during login.
     */
    private final PasswordEncoder passwordEncoder;


    /**
     * Creates a LoginService with the required repository.
     *
     * @param userRepository Repository used to store users.
     * @param passwordEncoder Used to verify encrypted passwords.
     */
    public LoginService(UserRepository userRepository,
                        PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    /**
     * Checks whether a user can log in.
     *
     * @param  loginRequest user info from the LoginRequest form
     * @return Login result.
     */
    public User login(LoginRequest loginRequest) {

            User user = userRepository.findByUsername(loginRequest.getUsername());

            if (user == null) {
                return null;
            }
            if (passwordEncoder.matches(loginRequest.getPassword(),
                user.getPassword())) {

            return user;

            }

            return null;
        }
}