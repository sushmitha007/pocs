package com.stackroute.taskrobo.dao;

import com.stackroute.taskrobo.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean saveTask(Task task) {
        try {
            String saveQuery = "insert into task (taskId, taskTitle, taskContent, taskStatus) values (?,?,?,?)";
            jdbcTemplate.update("INSERT INTO TASK VALUES (?, ?,?,?)", task.getTaskId(), task.getTaskTitle(), task.getTaskContent(), task.getTaskStatus());
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteTask(int taskId) {

        try {

            String deleteQuery = "DELETE FROM task WHERE taskId = ?";
            Object[] args = new Object[]{taskId};

            return jdbcTemplate.update(deleteQuery, args) == 1;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> getAllTasks() {
        String getAllQuery = "SELECT * FROM task";

        List<Task> allTasks = jdbcTemplate.query(getAllQuery, new TaskMapper());

        return allTasks;
    }

    @Override
    public Task getTaskById(int taskId) {
        Task task;
        try {
            String getQuery = "SELECT * FROM task WHERE taskId=" + taskId;
            task = jdbcTemplate.queryForObject(getQuery, new TaskMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return task;
    }

    @Override
    public boolean updateTask(Task task) {
        String updateQuery = "update task set taskStatus = ? where taskId = ?";
        return jdbcTemplate.update(updateQuery, task.getTaskStatus(), task.getTaskId()) == 1;
    }

    private static final class TaskMapper implements RowMapper<Task> {

        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            task.setTaskId(rs.getInt("taskId"));
            task.setTaskTitle(rs.getString("taskTitle"));
            task.setTaskContent(rs.getString("taskContent"));
            task.setTaskStatus(rs.getString("taskStatus"));
            return task;
        }
    }
}
