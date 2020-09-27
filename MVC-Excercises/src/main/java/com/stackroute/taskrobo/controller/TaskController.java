package com.stackroute.taskrobo.controller;

import com.stackroute.taskrobo.exception.TaskAlreadyExistException;
import com.stackroute.taskrobo.exception.TaskDoesNotExistException;
import com.stackroute.taskrobo.model.Task;
import com.stackroute.taskrobo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @RequestMapping("/hey")
    public String sayHello(Model model) {
        model.addAttribute("msg", "Hello Earth");
        return "index";
    }
    @RequestMapping("/")
    public String indexPage(ModelMap model) {

        model.addAttribute("tasks", taskService.getAllTasks());

        return "index";
    }

    // Add New Note

    @PostMapping("addTask")
    public String addNote(@ModelAttribute("task") Task task, ModelMap model) throws TaskAlreadyExistException {

        if (task.getTaskTitle().isEmpty()) {
            model.addAttribute("errorMessage", "Fields should not be empty");
            return "index";
        } else {
            try {
                taskService.addTask(task);
                model.addAttribute("tasks", taskService.getAllTasks());

            } catch (TaskAlreadyExistException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                model.addAttribute("errorMessage", e.getMessage());
            }

            return "redirect:/";

        }

    }

    // Delete a Note

    @DeleteMapping("deleteTask")
    public String deleteNote(@RequestParam("taskId") int taskId, ModelMap modelMap) throws TaskDoesNotExistException {

        try {
            taskService.deleteTask(taskId);
        } catch (TaskDoesNotExistException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", e.getMessage());
            return "index";
        }
        return "redirect:/";
    }


    // Update a Note

    @PostMapping("updateTask")
    public String updateTask(@ModelAttribute("task") Task task, ModelMap model) throws TaskDoesNotExistException {
        if (task.getTaskStatus().isEmpty()) {
            model.addAttribute("errorMessage", "Id cannot be null");
            return "index";
        } else {
            try {
                taskService.updateTask(task);
                model.addAttribute("tasks", taskService.getAllTasks());

            } catch (TaskDoesNotExistException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                model.addAttribute("errorMessage", e.getMessage());
            }

            return "redirect:/";

        }

    }

    @GetMapping("getTask")
    public String getNoteById(@RequestParam int taskId, ModelMap model) throws TaskDoesNotExistException {

        try {
            taskService.getTask(taskId);
            model.addAttribute("task", taskService.getTask(taskId));

        } catch (TaskDoesNotExistException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/";

    }
}

