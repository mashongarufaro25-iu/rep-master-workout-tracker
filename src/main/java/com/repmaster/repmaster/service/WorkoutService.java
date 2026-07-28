package com.repmaster.repmaster.service;

import com.repmaster.repmaster.dto.WorkoutRequest;
import com.repmaster.repmaster.entity.Workout;
import com.repmaster.repmaster.repository.WorkoutRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Handles the workouts.
 */
@Service
public class WorkoutService {
    /**
     * Repository used to save workouts and their data.
     */
    private final WorkoutRepository  workoutRepository;

    /**
     * Creates a WorkoutService.
     *
     * @param workoutRepository Repository for workout data.
     */
    public WorkoutService(WorkoutRepository  workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    /**
     * Gets the new workout .
     *
     * @param request workout  details received from the client.
     * @return Confirmation message.
     */
    public String createWorkout(WorkoutRequest request) {

        Workout workout = new Workout();

        workout.setWorkoutName(request.getWorkoutName());
        workout.setTargetMuscle(request.getTargetMuscle());
        workout.setExercises(request.getExercises());
        workout.setSets(request.getSets());
        workout.setReps(request.getReps());

        workoutRepository.save(workout);

        return "Workout created successfully!";
    }
    /**
     * Returns all saved workouts.
     *
     * @return List of workouts.
     */
    public List<Workout> getAllWorkouts() {

        return workoutRepository.findAll();

    }

}