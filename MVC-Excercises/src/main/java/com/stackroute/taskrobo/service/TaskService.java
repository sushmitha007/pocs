package com.stackroute.taskrobo.service;

import com.stackroute.taskrobo.exception.TaskAlreadyExistException;
import com.stackroute.taskrobo.exception.TaskDoesNotExistException;
import com.stackroute.taskrobo.model.Task;

import java.util.List;

public interface TaskService {
    boolean addTask(Task task) throws TaskAlreadyExistException;
    Task updateTask(Task task) throws TaskDoesNotExistException;
    Task getTask(int taskId) throws TaskDoesNotExistException;
    List<Task> getAllTasks();
    Task deleteTask(int taskId) throws TaskDoesNotExistException;

}
