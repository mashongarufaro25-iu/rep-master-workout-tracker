package com.repmaster.repmaster.service;

import com.repmaster.repmaster.repository.LoginRepository;
import org.springframework.stereotype.Service;





/**
 * Handles the business logic for user login.
 */
@Service
public class LoginService {

    /**
     * Repository responsible for data access.
     */
    private final LoginRepository loginRepository;


    /**
     * Creates a LoginService with the required repository.
     *
     * @param loginRepository Repository used for login data.
     */
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * Processes a login request.
     *
     * @param username Username entered by the user.
     * @param password Password entered by the user.
     * @return Confirmation message.
     */
    public String login(String username, String password) {

        return loginRepository.login(username, password);

    }

}