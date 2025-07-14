package com.taskmanager.service;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskStatus;
import com.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceImplTest {

    private TaskRepository repository;
    private TaskServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        service = new TaskServiceImpl(repository);
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setStatus(TaskStatus.TODO);

        when(repository.save(Mockito.any(Task.class))).thenReturn(task);

        Task created = service.createTask(task);
        assertNotNull(created);
        assertEquals("Test Task", created.getTitle());
    }

    @Test
    void testGetAllTasks() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(service.getAllTasks().isEmpty());
    }

    @Test
    void testUpdateTask() {
        UUID id = UUID.randomUUID();
        Task existing = new Task();
        existing.setId(id);
        existing.setTitle("Old Title");
        existing.setStatus(TaskStatus.TODO);

        Task updated = new Task();
        updated.setTitle("New Title");
        updated.setStatus(TaskStatus.IN_PROGRESS);

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        when(repository.save(Mockito.any(Task.class))).thenReturn(existing);

        Task result = service.updateTask(id, updated);
        assertEquals("New Title", result.getTitle());
        assertEquals(TaskStatus.IN_PROGRESS, result.getStatus());
    }

    @Test
    void testDeleteTask() {
        UUID id = UUID.randomUUID();
        doNothing().when(repository).deleteById(id);
        service.deleteTask(id);
        verify(repository).deleteById(id);
    }
}