package com.taskmanager.repository;

import com.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Repository interface for Task entities.
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {
}