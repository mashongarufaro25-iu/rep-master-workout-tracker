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
     * Updates an existing workout in the database.
     *
     * @param id The ID of the workout to update.
     * @param updatedWorkout The workout object containing the new values entered by the user.
     * @return A success message if the workout was updated, or an error message if the workout was not found.
     */
    public String updateWorkout(Long id, Workout updatedWorkout) {

        // Search the database for the workout with the given ID
        Workout workout = workoutRepository.findById(id).orElse(null);

        // Check if the workout exists
        if (workout == null) {

            return "Workout not found";

        }

        // Update the workout's name
        workout.setWorkoutName(updatedWorkout.getWorkoutName());

        // Update the target muscle
        workout.setTargetMuscle(updatedWorkout.getTargetMuscle());

        // Update the exercises
        workout.setExercises(updatedWorkout.getExercises());

        // Update the number of sets
        workout.setSets(updatedWorkout.getSets());

        // Update the number of repetitions
        workout.setReps(updatedWorkout.getReps());

        // Save the updated workout back to the database
        workoutRepository.save(workout);

        // Return a success message
        return "Workout updated successfully";

    }

    /**
     * Deletes a workout from the database.
     *
     * @param id The ID of the workout to delete.
     * @return A success message if the workout was deleted successfully.
     */
    public String deleteWorkout(Long id) {

        // Delete the workout with the given ID from the database
        workoutRepository.deleteById(id);

        // Return a success message
        return "Workout deleted successfully";

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