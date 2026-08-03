package com.repmaster.repmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Represents a workout log completed by the user.
 */
@Entity
public class WorkoutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    /**
     * User who created this workout log.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String workoutDate;

    private Integer duration;

    private String notes;

    public WorkoutLog() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    /**
     * Returns the workout linked to this workout log.
     *
     * @return The associated workout.
     */
    public Workout getWorkout() {

        return workout;

    }

    /**
     * Sets the workout linked to this workout log.
     *
     * @param workout The workout to associate with this log.
     */
    public void setWorkout(Workout workout) {

        this.workout = workout;

    }

    public String getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
