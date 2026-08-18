package com.repmaster.repmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


/**
 * Represents a workout log completed by the user.
 * Stores the workout, the user, and details about the session.
 */
@Entity
public class WorkoutLog {

    /**
     * Unique ID for each workout log.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The workout that this log belongs to.
     */
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    /**
     * User who created this workout log.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Date when the workout was done.
     */
    private String workoutDate;

    /**
     * Duration of the workout in minutes.
     */
    private Integer duration;

    /**
     * Extra notes written by the user.
     */
    private String notes;

    /**
     * Empty constructor needed by JPA.
     */
    public WorkoutLog() {
    }


    //GETTERS
    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public String getWorkoutDate() {
        return workoutDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getNotes() {
        return notes;
    }

    //SETTERS
    public void setUser(User user) {
        this.user = user;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
