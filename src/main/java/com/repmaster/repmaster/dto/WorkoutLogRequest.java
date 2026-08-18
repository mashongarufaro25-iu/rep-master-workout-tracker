package com.repmaster.repmaster.dto;



/**
 * Represents the data sent from the frontend
 * when a user saves a workout log.
 */
public class WorkoutLogRequest {

    /**
     * The ID of the workout being logged.
     */
    private Long workoutId;

    /**
     * The ID of the user who created the log.
     */
    private Long userId;

    /**
     * The date when the workout was done.
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
     * Empty constructor needed for JSON and Spring.
     */
    public WorkoutLogRequest() {
    }


    //GETTERS
    public Long getUserId() {

        return userId;
    }

    public Long getWorkoutId() {
        return workoutId;
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
    public void setUserId(Long userId) { this.userId = userId;}

    public void setWorkoutId(Long workoutId) {

        this.workoutId = workoutId;
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