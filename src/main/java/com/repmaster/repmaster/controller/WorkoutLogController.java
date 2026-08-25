package com.repmaster.repmaster.controller;


import com.repmaster.repmaster.dto.WorkoutLogRequest;
import com.repmaster.repmaster.entity.WorkoutLog;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.repmaster.repmaster.service.WorkoutLogService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Handles HTTP requests for workout logs.
 */
@RestController
@RequestMapping("/api")
public class WorkoutLogController {

    @Autowired
    private WorkoutLogService workoutLogService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * Saves a new workout log.
     *
     * @param request The workout log submitted by the user.
     * @return A success message.
     */
    @PostMapping("/workout-log")
    public String createWorkoutLog(@RequestBody WorkoutLogRequest request) {

        return workoutLogService.createWorkoutLog(request);

    }

    /**
     * Returns all saved workout logs.
     *
     * @return A list of workout logs.
     */
    @GetMapping("/workout-logs")
    public List<WorkoutLog> getAllWorkoutLogs(@RequestParam Long userId) {

        return workoutLogService.getAllWorkoutLogs(userId);

    }

    /**
     * Updates an existing workout log.
     *
     * @param id The ID of the workout log to update.
     * @param request The updated workout log details.
     * @return A success or error message.
     */
    @PutMapping("/workout-log/{id}")
    public String updateWorkoutLog( @PathVariable Long id, @RequestBody WorkoutLogRequest request) {

        return workoutLogService.updateWorkoutLog(id, request);
    }


    /**
     * Deletes an existing workout log.
     *
     * @param id The ID of the workout log to delete.
     * @return A success or error message.
     */
    @DeleteMapping("/workout-log/{id}")
    public String deleteWorkoutLog(@PathVariable Long id) {

        return workoutLogService.deleteWorkoutLog(id);
    }

}
