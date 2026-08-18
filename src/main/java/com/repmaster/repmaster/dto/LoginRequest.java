package com.repmaster.repmaster.dto;

/**
 * Holds the data sent when a user logs in.
 * It stores the username and password.
 */
public class LoginRequest {

    /**
     * The user's username.
     */
    private String username;

    /**
     * The user's password.
     */
    private String password;

    /**
     * Empty constructor.
     * Needed for JSON and Spring.
     */
    public LoginRequest() {
    }
    //GETTERS
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //SETTERS
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
