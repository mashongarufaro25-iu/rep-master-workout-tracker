package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.dto.WorkoutRequest;
import com.repmaster.repmaster.service.WorkoutService;
import com.repmaster.repmaster.entity.Workout;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles workout requests.
 */
@RestController
@RequestMapping("/api")
public class WorkoutController {

    /**
     * Service responsible for handling workouts.
     */
    private final WorkoutService workoutService;

    /**
     * Creates a Workout Controller.
     *
     * @param workoutService Service used for workout info.
     */
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Saves a new workout.
     *
     * @param request Workout data received from the browser.
     * @return Workout result.
     */
    @PostMapping("/workout")
    public String createWorkout(@RequestBody WorkoutRequest request) {

        return workoutService.createWorkout(request);

    }

    /**
     * Updates an existing workout.
     *
     * @param id the workout id.
     * @param workout the workout object to be edited
     * @return returns updated workout.
     */
    @PutMapping("/workout/{id}")
    public String updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {

        return workoutService.updateWorkout(id, workout);

    }

    /**
     * Deletes an existing workout.
     *
     * @param id The ID of the workout to delete.
     * @return A success message after the workout has been deleted.
     */
    @DeleteMapping("/workout/{id}")
    public String deleteWorkout(@PathVariable Long id) {

        return workoutService.deleteWorkout(id);

    }

    /**
     * Returns all saved workouts.
     *
     * @return List of workouts.
     */
    @GetMapping("/workouts")
    public List<Workout> getAllWorkouts() {

        return workoutService.getAllWorkouts();

    }

}