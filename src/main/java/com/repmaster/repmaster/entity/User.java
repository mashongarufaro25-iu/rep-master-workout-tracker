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
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * User's email address.
     */
    private String email;

    /**
     * User's phone number.
     */
    private String phoneNumber;

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
     * @param firstName User's firstname.
     * @param lastName User's lastname.
     * @param username User's username.
     * @param email User's email.
     * @param phoneNumber User's phone number.
     * @param password User's password.
     */
    public User(String firstName,String lastName,String username,String email,String phoneNumber, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    // Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}