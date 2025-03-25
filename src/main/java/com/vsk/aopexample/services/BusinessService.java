package com.vsk.aopexample.services;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    public String processTask(String taskName) {
        if (taskName == null || taskName.isBlank()) { // Using isBlank() from JDK 11 (still relevant in JDK 21)
            throw new IllegalArgumentException("Task name cannot be empty or blank");
        }

        // Using pattern matching for more readable number checks
        if (taskName.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Task name cannot be a number");
        }

        return "Processing task: " + taskName;
    }
}
