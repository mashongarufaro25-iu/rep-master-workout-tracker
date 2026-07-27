package com.repmaster.repmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a created workout in the RepMaster application.
 */
@Entity
public class Workout {
    /**
     * Unique ID for each user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the workout.
     */
    private String workoutName;

    /**
     * Target muscle group.
     */
    private String targetMuscle;

    /**
     * Workout exercises.
     */
    private String exercises;

    /**
     * Planned number of sets.
     */
    private Integer sets;

    /**
     * Planned number of repetitions.
     */
    private Integer reps;

    public Long getId() {
        return id;
    }

    /**
     * Default constructor.
     */
    public Workout() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }
}
