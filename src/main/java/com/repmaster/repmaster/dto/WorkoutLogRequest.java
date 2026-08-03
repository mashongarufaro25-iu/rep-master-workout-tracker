package com.repmaster.repmaster.dto;



/**
 * Represents the data sent from the frontend
 * when a user saves a workout log.
 */
public class WorkoutLogRequest {

    private Long workoutId;

    private Long userId;

    private String workoutDate;

    private Integer duration;

    private String notes;

    public WorkoutLogRequest() {
    }



    /**
     * Returns the selected user ID.
     *
     * @return The user ID.
     */
    public Long getUserId() {   return userId; }

    /**
     * Sets the selected user ID.
     *
     * @param userId The user ID.
     */
    public void setUserId(Long userId) { this.userId = userId;}



    /**
     * Returns the selected workout ID.
     *
     * @return The workout ID.
     */
    public Long getWorkoutId() {
        return workoutId;
    }

    /**
     * Sets the selected workout ID.
     *
     * @param workoutId The workout ID.
     */
    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    /**
     * Returns the workout date.
     *
     * @return The workout date.
     */
    public String getWorkoutDate() {
        return workoutDate;
    }

    /**
     * Sets the workout date.
     *
     * @param workoutDate The workout date.
     */
    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    /**
     * Returns the workout duration.
     *
     * @return Duration in minutes.
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the workout duration.
     *
     * @param duration Duration in minutes.
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Returns the workout notes.
     *
     * @return Workout notes.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the workout notes.
     *
     * @param notes Workout notes.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}