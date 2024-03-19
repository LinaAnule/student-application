package com.swedbank.StudentApplication.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping("/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable long id) {
        taskService.update(task, id);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        taskService.delete(id);
    }


}
