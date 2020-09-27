package com.stackroute.taskrobo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Task implements Serializable {

	@Id
	private int taskId;
	private String taskTitle;
	private String taskContent;
	private String taskStatus;

	public Task() {
	}

	public Task(int taskId, String taskTitle, String taskContent, String taskStatus) {
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskContent = taskContent;
		this.taskStatus = taskStatus;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Task{" +
				"taskId=" + taskId +
				", taskTitle='" + taskTitle + '\'' +
				", taskContent='" + taskContent + '\'' +
				", taskStatus='" + taskStatus + '\'' +
				'}';
	}
}
