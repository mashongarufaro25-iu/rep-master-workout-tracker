package com.repmaster.repmaster.repository;

import com.repmaster.repmaster.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Workout entities.
 */
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}