package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository for managing Workout entities.
 */
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    /**
     * Finds all workouts that belong to a specific user.
     *
     * @param user the user whose workouts we want
     * @return list of workouts for that user
     */
    List<Workout> findByUser(User user);

}