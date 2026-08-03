package com.repmaster.repmaster.service;

import com.repmaster.repmaster.entity.User;
import com.repmaster.repmaster.entity.Workout;
import com.repmaster.repmaster.entity.WorkoutLog;
import com.repmaster.repmaster.dto.WorkoutLogRequest;
import com.repmaster.repmaster.repository.UserRepository;
import com.repmaster.repmaster.repository.WorkoutLogRepository;
import com.repmaster.repmaster.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


/**
 * Handles the business logic for workout logs.
 */
@Service
public class WorkoutLogService {

    @Autowired
    private WorkoutLogRepository workoutLogRepository;
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a workout log.
     *
     * @param workoutLog The workout log to save.
     * @return A success message.
     */
    /**
     * Saves a workout log.
     *
     * @param request The workout log request received from the frontend.
     * @return A success message.
     */
    public String createWorkoutLog(WorkoutLogRequest request) {

        // Find the selected workout
        Workout workout = workoutRepository.findById(request.getWorkoutId()).orElse(null);

        if (workout == null) {

            return "Workout not found.";

        }

        // Find the logged-in user
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {

            return "User not found.";

        }

        // Create a new workout log
        WorkoutLog workoutLog = new WorkoutLog();

        workoutLog.setUser(user);
        workoutLog.setWorkout(workout);
        workoutLog.setWorkoutDate(request.getWorkoutDate());
        workoutLog.setDuration(request.getDuration());
        workoutLog.setNotes(request.getNotes());

        // Save the workout log
        workoutLogRepository.save(workoutLog);

        return "Workout log saved successfully.";

    }

    /**
     * Returns all workout logs.
     *
     * @return A list of workout logs.
     */
    public List<WorkoutLog> getAllWorkoutLogs() {

        return workoutLogRepository.findAll();

    }

    public List<WorkoutLog> getAllWorkoutLogs(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return new ArrayList<>();
        }

        return workoutLogRepository.findByUser(user);

    }

}
