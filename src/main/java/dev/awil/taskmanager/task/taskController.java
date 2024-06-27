package dev.awil.taskmanager.task;

import java.util.*;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class taskController {

    @Autowired
    private taskService taskService;
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(Principal principal) {
        return taskService.getAllTasks();
    }

    @GetMapping("task/{id}")
    public Task getTaskById(@PathVariable Long id) { 
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found.");
        }
        return task.get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("task/{id}")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("task/{id}")
    public boolean deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return true;
    }
    
}
