package com.springmongo.service;

import com.springmongo.model.Task;
import com.springmongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // create read, update, delete

    public Task addTask(Task task) {
        task.setId(1);
        return taskRepository.save(task);
    }

}
