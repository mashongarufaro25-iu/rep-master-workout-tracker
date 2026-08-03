package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for managing WorkoutLog records.
 */
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByUser(User user);


}