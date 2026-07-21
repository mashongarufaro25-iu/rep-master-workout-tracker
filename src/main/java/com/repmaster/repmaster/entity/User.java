package com.repmaster.repmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a user in the RepMaster application.
 */
@Entity
public class User {

    /**
     * Unique ID for each user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User's username.
     */
    private String username;

    /**
     * User's password.
     */
    private String password;

    /**
     * Default constructor required by JPA.
     */
    public User() {
    }

    /**
     * Constructor used to create a new user.
     *
     * @param username User's username.
     * @param password User's password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //  Getters

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}