package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing User entities.
 * This lets us save, find, update, and delete users.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by username.
     *
     * @param username the username to search for
     * @return the user with this username
     */
    User findByUsername(String username);


    /**
     * Finds a user by email.
     *
     * @param email the email to search for
     * @return the user with this email
     */
    User findByEmail(String email);
}


