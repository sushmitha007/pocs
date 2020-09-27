//package com.stackroute.taskrobo.commander.test;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.time.LocalDateTime;
//
//import java.util.Arrays;
//
//import com.stackroute.taskrobo.controller.TaskController;
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
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//
//public class TaskControllerTest {
//    private MockMvc mockMvc;
//
//    private Task task;
//
//    @Mock
//    private TaskServiceImpl taskService;
//
//    @InjectMocks
//    private TaskController taskController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
//
//        task = new Task(200, "task10", "Reading", "WIP");
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        task = null;
//    }
//
//    @Test
//    public void givenValidTaskThenRedirectSlash() throws Exception {
//        when(taskService.addTask(any())).thenReturn(true);
//        mockMvc.perform(post("/api/v1/addTask").param("taskTitle", task.getTaskTitle()))
//                .andExpect(status().isFound()).andExpect(redirectedUrl("/"));
//    }
//
//    @Test
//    public void givenInvalidTaskThenForwardToIndex() throws Exception {
//        when(taskService.addTask(any(Task.class))).thenThrow(TaskAlreadyExistException.class);
//        mockMvc.perform(post("/api/v1/addTask").param("taskTitle", "")).andExpect(status().isOk())
//                .andExpect(forwardedUrl("index"));
//    }
//
//    @Test
//    public void givenValidTaskIdWhenDeletedThenRedirectToSlash() throws Exception {
//        when(taskService.deleteTask(task.getTaskId())).thenReturn(task);
//        mockMvc.perform(delete("/api/v1/deleteTask").param("taskId", String.valueOf(200))).andExpect(redirectedUrl("/"));
//
//    }
//
//    @Test
//    public void givenInValidTaskIdWhenDeletedThenRedirectToSlash() throws Exception {
//        when(taskService.deleteTask(task.getTaskId())).thenThrow(TaskDoesNotExistException.class);
//        mockMvc.perform(delete("/api/v1/deleteTask").param("taskId", String.valueOf(3000))).andExpect(redirectedUrl("/"));
//
//    }
//
//    @Test
//    public void givenValidTaskIdThenReturnTaskAndRedirectToSlash() throws Exception {
//        when(taskService.getTask(task.getTaskId())).thenReturn(task);
//        mockMvc.perform(get("/api/v1/getTask").param("taskId", String.valueOf(200))).andExpect(redirectedUrl("/"));
//
//    }
//
//    @Test
//    public void givenInvalidTaskIdThenRedirectToSlash() throws Exception {
//        when(taskService.getTask(task.getTaskId())).thenThrow(TaskDoesNotExistException.class);
//        mockMvc.perform(get("/api/v1/getTask").param("taskId", String.valueOf(2000))).andExpect(redirectedUrl("/"));
//
//    }
//
//    @Test
//    public void givenValidTaskDetailsWhenUpdatedRedirectSlash() throws Exception {
//        when(taskService.updateTask(any(Task.class))).thenReturn(task);
//        mockMvc.perform(post("/api/v1/updateTask").param("taskStatus", "completed")).andExpect(status().isFound()).andExpect(redirectedUrl("/"));
//    }
//
//    @Test
//    public void givenInvalidTaskDetailsWhenUpdatedForwardToIndex() throws Exception {
//        when(taskService.updateTask(any(Task.class))).thenThrow(TaskDoesNotExistException.class);
//        mockMvc.perform(post("/api/v1/updateTask").param("taskStatus", "")).andExpect(status().isOk())
//                .andExpect(forwardedUrl("index"));
//    }
//
//}
