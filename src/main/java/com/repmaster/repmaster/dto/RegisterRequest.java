package com.repmaster.repmaster.dto;

/**
 * DTO used to transfer registration data
 * from the client to the server.
 */
public class RegisterRequest {

    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * Username used for login.
     */
    private String username;

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
     * Default constructor required by Spring.
     */
    public RegisterRequest() {
    }
   // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    // Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
