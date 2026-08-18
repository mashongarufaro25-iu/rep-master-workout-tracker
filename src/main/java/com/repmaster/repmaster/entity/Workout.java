package com.repmaster.repmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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

    /**
     * User who owns this workout.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    /**
     * Default constructor.
     */
    public Workout() {
    }


    //GETTERS
    public String getWorkoutName() {
        return workoutName;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public String getExercises() {
        return exercises;
    }

    public Integer getSets() {
        return sets;
    }

    public Integer getReps() {
        return reps;
    }

    public User getUser() {
        return user;
    }


   //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
