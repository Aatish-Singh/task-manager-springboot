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
    public Task addTask(@RequestParam String name, @RequestParam String status){
        return taskService.addTask(name,status);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id,
                           @RequestParam String name,
                           @RequestParam String status){
        return taskService.updateTask(id, name, status);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        boolean deleted = taskService.deleteTask(id);
        return deleted? "Deleted":"Not Found";
    }
}
