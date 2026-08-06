package com.repmaster.repmaster.controller;


import com.repmaster.repmaster.dto.WorkoutLogRequest;
import com.repmaster.repmaster.entity.WorkoutLog;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.repmaster.repmaster.service.WorkoutLogService;
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

}
