package com.repmaster.repmaster.dto;


/**
 * DTO used to transfer workout data
 * from the client to the server.
 */
public class WorkoutRequest {
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
     * ID of the user creating the workout.
     */
    private Long userId;

    /**
     * Default constructor required by Spring.
     */
    public WorkoutRequest() {
    }


    // Getters

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

    public Long getUserId() {  return userId; }




    // Setters


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

    public void setUserId(Long userId) { this.userId = userId;}


}
