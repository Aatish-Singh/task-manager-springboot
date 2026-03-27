package com.example.demo.service;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task addTask(String name, String status){
        return taskRepository.save(new Task(name, status));
    }
    public Task updateTask(int id,String name, String status){
       Task task = taskRepository.findById(id).orElse(null);
       if(task != null){
           task.setName(name);
           task.setStatus(status);
           return taskRepository.save(task);
       }
        return null;
    }
    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }
}
