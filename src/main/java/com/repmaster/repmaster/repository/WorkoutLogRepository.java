package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for managing WorkoutLog records.
 * Handles saving, finding, and deleting workout logs.
 */
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    /**
     * Finds all workout logs created by a specific user.
     *
     * @param user the user whose logs we want
     * @return list of workout logs for that user
     */
    List<WorkoutLog> findByUser(User user);


}