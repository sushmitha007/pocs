//package com.stackroute.taskrobo.commander.test;
//
//
//import com.stackroute.taskrobo.dao.TaskDAO;
//import com.stackroute.taskrobo.dao.TaskDAOImpl;
//import com.stackroute.taskrobo.model.Task;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
//@Transactional
//@Rollback
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class TaskDAOImplTest {
//
//    private TaskDAO taskDAO;
//    private static Task task;
//    private static final String MESSAGE_ONE = "Given task to be saved should return true";
//    private static final String MESSAGE_TWO = "Given task cannot be saved because task with same taskId already exists";
//    private static final String MESSAGE_THREE = "Given valid taskId should return task object";
//    private static final String MESSAGE_FOUR = "Given invalid taskId to search should return null";
//    private static final String MESSAGE_FIVE = "Given valid taskId should delete the record and return true ";
//    private static final String MESSAGE_SIX = "Given invalid taskId should not delete the record and return false ";
//    private static final String MESSAGE_SEVEN = "Given valid task details should update the record";
//    private static final String MESSAGE_EIGHT = "Given invalid task details should not update the record";
//    private static final String MESSAGE_NINE = "Should return all the tasks";
//
//
//    private static ApplicationContext context;
//
//
//    @BeforeAll
//    public static void initContext() {
//        context = new ClassPathXmlApplicationContext("beans.xml");
//    }
//
//    @BeforeEach
//    public void init() {
//        context = new ClassPathXmlApplicationContext("beans.xml");
//        task = (Task) context.getBean("task");
//        taskDAO = (TaskDAO) context.getBean("taskDAO");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        taskDAO = null;
//
//    }
//
//    @Test
//    @Order(1)
//    public void givenValidTaskDataWhenSavedThenReturnTrue() throws Exception {
//        assertTrue(taskDAO.saveTask(task), MESSAGE_ONE);
//    }
//
//    @Test
//    @Order(1)
//    public void givenInValidTaskDataWhenSavedThenReturnFalse() throws Exception {
//        assertTrue(taskDAO.saveTask(task), MESSAGE_ONE);
//        Task newTask = new Task(110, "task7", "abc", "pending");
//        assertFalse(taskDAO.saveTask(newTask), MESSAGE_TWO);
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(2)
//    public void givenValidTaskIdThenReturnTask() {
//        assertTrue(taskDAO.saveTask(task), MESSAGE_ONE);
//        assertEquals(task.toString(), taskDAO.getTaskById(110).toString(), MESSAGE_THREE);
//
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(2)
//    public void givenInvalidTaskIdThenReturnNull() {
//        assertNull(taskDAO.getTaskById(1000), MESSAGE_FOUR);
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(3)
//    public void givenValidTaskIdWhenDeleteThenReturnTrue() {
//        assertTrue(taskDAO.deleteTask(102), MESSAGE_FIVE);
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(3)
//    public void givenInValidTaskIdWhenDeleteThenReturnFalse() {
//        assertFalse(taskDAO.deleteTask(500), MESSAGE_SIX);
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(4)
//    public void givenValidDetailsWhenUpdatedThenReturnDetails() {
//        task = new Task(101, "task1", "Practise core java", "WIP");
//        assertTrue(taskDAO.updateTask(task), MESSAGE_SEVEN);
//        Task updatedTask = taskDAO.getTaskById(101);
//        assertEquals(task.getTaskStatus(), updatedTask.getTaskStatus());
//    }
//
//    @Test
//    @Rollback(true)
//    @Order(4)
//    public void givenInValidDetailsWhenUpdatedThenReturnFalse() {
//        task = new Task(1000, "task1", "Practise core java", "Completed");
//        assertFalse(taskDAO.updateTask(task), MESSAGE_EIGHT);
//    }
//
//    @Test
//    @Order(5)
//    public void givenTaskDataWhenSavedThenReturnAllTasks() throws Exception {
//        List<Task> taskList = taskDAO.getAllTasks();
//        assertEquals(101, taskList.get(0).getTaskId(), MESSAGE_NINE);
//    }
//
//
//}
