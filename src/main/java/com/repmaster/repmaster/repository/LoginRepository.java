package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.repository.LoginRepository;
import org.springframework.stereotype.Repository;

/**
 * Simulates database operations for login.
 */
@Repository
public class LoginRepository {


    /**
     * Simulates saving or checking login details.
     *
     * @param username Username entered.
     * @param password Password entered.
     * @return Confirmation message.
     */
    public String login(String username, String password) {

        System.out.println("Repository received username: " + username);
        System.out.println("Repository received password: " + password);

        return "Login request received successfully!";

    }

}