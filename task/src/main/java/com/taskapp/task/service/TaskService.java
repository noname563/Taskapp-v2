package com.taskapp.task.service;

import com.taskapp.task.entity.Task;
import com.taskapp.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(Task task) {
        taskRepository.save(task);
        return "Task created successfully for user ID: " + task.getUserId();
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }
    public String deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return "Task deleted successfully for user ID: " + taskId;
    }
}
