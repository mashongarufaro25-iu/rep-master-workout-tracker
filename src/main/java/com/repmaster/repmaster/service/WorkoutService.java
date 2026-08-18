package com.repmaster.repmaster.service;

import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.repository.UserRepository;
import com.repmaster.repmaster.dto.WorkoutRequest;
import com.repmaster.repmaster.entity.Workout;
import com.repmaster.repmaster.repository.WorkoutRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles workout actions such as creating, updating, deleting,
 * and getting workouts.
 */
@Service
public class WorkoutService {
    /**
     * Repository used to save workouts and their data.
     */
    private final WorkoutRepository  workoutRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {
            return "User not found.";
        }

        // Validate workout name
        if (request.getWorkoutName() == null
                || request.getWorkoutName().trim().isEmpty()) {

            return "Workout name is required.";

        }

        // Validate target muscle
        if (request.getTargetMuscle() == null
                || request.getTargetMuscle().trim().isEmpty()) {

            return "Target muscle is required.";

        }

        // Validate exercises
        if (request.getExercises() == null
                || request.getExercises().trim().isEmpty()) {

            return "Exercises are required.";

        }

        // Validate sets
        if (request.getSets() == null || request.getSets() <= 0) {

            return "Sets must be greater than zero.";

        }

        // Validate reps
        if (request.getReps() == null || request.getReps() <= 0) {

            return "Reps must be greater than zero.";

        }

        Workout workout = new Workout();

        workout.setWorkoutName(request.getWorkoutName());
        workout.setTargetMuscle(request.getTargetMuscle());
        workout.setExercises(request.getExercises());
        workout.setSets(request.getSets());
        workout.setReps(request.getReps());

        // Attach the owner
        workout.setUser(user);

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
     * @param userId the user's ID
     * @return List of workouts.
     */
    public List<Workout> getAllWorkouts(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return new ArrayList<>();
        }

        return workoutRepository.findByUser(user);

    }

}