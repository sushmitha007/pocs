package com.stackroute.taskrobo.dao;

import com.stackroute.taskrobo.model.Task;

import java.util.List;


public interface TaskDAO {

	public boolean saveTask(Task task);

	public boolean deleteTask(int taskId);

	public List<Task> getAllTasks();

	public Task getTaskById(int taskId);

	public boolean updateTask(Task task);

}
