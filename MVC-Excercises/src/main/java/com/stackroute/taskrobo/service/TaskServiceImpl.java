package com.stackroute.taskrobo.service;

import com.stackroute.taskrobo.dao.TaskDAO;
import com.stackroute.taskrobo.exception.TaskAlreadyExistException;
import com.stackroute.taskrobo.exception.TaskDoesNotExistException;
import com.stackroute.taskrobo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public boolean addTask(Task task) throws TaskAlreadyExistException {
        Task task1 = taskDAO.getTaskById(task.getTaskId());
        if (task1 != null) {
            throw new TaskAlreadyExistException("Task already exists.Kindly check the taskId");
        } else {
            taskDAO.saveTask(task);
            return true;
        }
    }

    @Override
    public Task updateTask(Task task) throws TaskDoesNotExistException {
        if (taskDAO.getTaskById(task.getTaskId()) != null) {
            if (taskDAO.updateTask(task)) {
                return task;
            }
        } else {
            throw new TaskDoesNotExistException("Task doesn't exists.Kindly check the taskId");
        }
        return null;
    }

    @Override
    public Task getTask(int taskId) throws TaskDoesNotExistException {
        if (taskDAO.getTaskById(taskId) != null) {
            return taskDAO.getTaskById(taskId);
        } else {
            throw new TaskDoesNotExistException("Task doesn't exists.Kindly check the taskId");
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    public Task deleteTask(int taskId) throws TaskDoesNotExistException {
        Task taskToBeDeleted = taskDAO.getTaskById(taskId);
        if (taskToBeDeleted != null) {
            return !taskDAO.deleteTask(taskId) ? null : taskToBeDeleted;
        } else {
            throw new TaskDoesNotExistException("Task to be delete is not found!");
        }
    }
}
