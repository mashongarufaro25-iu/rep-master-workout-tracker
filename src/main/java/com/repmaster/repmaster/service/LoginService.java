package com.repmaster.repmaster.service;

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
     * Saves a user to the database.
     *
     * @param username User's username.
     * @param password User's password.
     * @return Confirmation message.
     */
    public String login(String username, String password) {

        User user = new User(username, password);

        userRepository.save(user);

        return "User saved successfully!";

    }

}