//package com.stackroute.taskrobo.commander.test;
//
//import com.stackroute.taskrobo.dao.TaskDAOImpl;
//import com.stackroute.taskrobo.exception.TaskAlreadyExistException;
//import com.stackroute.taskrobo.exception.TaskDoesNotExistException;
//import com.stackroute.taskrobo.model.Task;
//import com.stackroute.taskrobo.service.TaskServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class TaskServiceImplTest {
//    @Mock
//    private TaskDAOImpl taskDAO;
//    @InjectMocks
//    private TaskServiceImpl taskService;
//
//    private Task task;
//
//    private List<Task> taskList;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//
//        MockitoAnnotations.initMocks(this);
//        task = new Task(200, "task10", "Reading", "WIP");
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        task = null;
//        taskList = null;
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenValidTaskWhenSavedThenReturnPlayer() throws TaskAlreadyExistException {
//        Task task = new Task(201, "task11", "Eating", "WIP");
//        when(taskDAO.getTaskById(anyInt())).thenReturn(null);
//        when(taskDAO.saveTask(any())).thenReturn(true);
//        assertTrue(taskService.addTask(task));
//        verify(taskDAO, times(1)).getTaskById(task.getTaskId());
//        verify(taskDAO, times(1)).saveTask(any());
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenDuplicateTaskThenThrowException() throws TaskAlreadyExistException {
//        when(taskDAO.getTaskById(anyInt())).thenReturn(task);
//        assertThrows(TaskAlreadyExistException.class, () -> taskService.addTask(task));
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//        verify(taskDAO, times(0)).saveTask(any());
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenValidTaskIdThenReturnTask() throws TaskDoesNotExistException {
//        when(taskDAO.getTaskById(anyInt())).thenReturn(task);
//        assertEquals(task, taskService.getTask(task.getTaskId()));
//        verify(taskDAO, times(2)).getTaskById(anyInt());
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenInvalidTaskIdException() throws TaskDoesNotExistException {
//        when(taskDAO.getTaskById(anyInt())).thenReturn(null);
//        assertThrows(TaskDoesNotExistException.class, () -> taskService.getTask(task.getTaskId()));
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenNothingThenReturnAllTeams() {
//
//        when(taskDAO.getAllTasks()).thenReturn(taskList);
//
//        assertEquals(taskList, taskService.getAllTasks());
//
//        verify(taskDAO, times(1)).getAllTasks();
//
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenValidTaskIdWhenDeletedThenReturnTrue() throws TaskDoesNotExistException {
//
//        when(taskDAO.getTaskById(anyInt())).thenReturn(task);
//        when(taskDAO.deleteTask(anyInt())).thenReturn(true);
//        assertEquals(task, taskService.deleteTask(task.getTaskId()));
//
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//        verify(taskDAO, times(1)).deleteTask(anyInt());
//
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenInValidTaskIdWhenDeletedThenThrowException() throws TaskDoesNotExistException {
//
//        when(taskDAO.getTaskById(anyInt())).thenReturn(null);
//
//        assertThrows(TaskDoesNotExistException.class, () -> taskService.deleteTask(task.getTaskId()));
//
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//        verify(taskDAO, times(0)).deleteTask(anyInt());
//
//    }
//
//    @Test
//    @Rollback(true)
//    public void givenValidTaskDetailsWhenUpdatedThenReturnUpdatedTask() throws TaskDoesNotExistException {
//        Task newTask = new Task(200, "task10", "Reading", "Completed");
//        when(taskDAO.getTaskById(anyInt())).thenReturn(task);
//        when(taskDAO.updateTask(any())).thenReturn(true);
//        Task updatedTask = taskService.updateTask(newTask);
//        assertEquals(newTask.getTaskStatus(), updatedTask.getTaskStatus());
//
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//        verify(taskDAO, times(1)).updateTask(any());
//
//    }
//    @Test
//    @Rollback(true)
//    public void givenInValidTaskDetailsWhenUpdatedThenThrowException() throws TaskDoesNotExistException {
//
//        when(taskDAO.getTaskById(anyInt())).thenReturn(null);
//
//        assertThrows(TaskDoesNotExistException.class, () -> taskService.updateTask(task));
//
//        verify(taskDAO, times(1)).getTaskById(anyInt());
//        verify(taskDAO, times(0)).updateTask(any());
//
//    }
//
//
//}
