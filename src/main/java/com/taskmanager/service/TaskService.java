package com.taskmanager.service;

import com.taskmanager.model.Task;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing tasks.
 */
public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(UUID id, Task task);
    void deleteTask(UUID id);
}