package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController{
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task.getName(),task.getStatus());
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id,
                           @RequestBody Task task){
        return taskService.updateTask(id,task.getName(), task.getStatus());
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Deleted";
    }
}
