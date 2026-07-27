package com.repmaster.repmaster.controller;

import com.repmaster.repmaster.dto.WorkoutRequest;
import com.repmaster.repmaster.service.WorkoutService;
import org.springframework.web.bind.annotation.RequestBody;
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

}