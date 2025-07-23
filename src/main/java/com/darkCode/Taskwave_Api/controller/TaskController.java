package com.darkCode.Taskwave_Api.controller;

import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.repository.TaskRepository;
import com.darkCode.Taskwave_Api.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Task>> getAll(){

        var tasks = service.getAll();

        return new ResponseEntity(tasks, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        var response = service.create(task);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Task> update(@RequestParam("id") String id) throws Exception {
        var response = service.update(id);

        return new ResponseEntity(response, HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity delete (@RequestParam("id") String id) throws Exception{
        service.delete(id);

        return new ResponseEntity("Deletado com sucesso", HttpStatus.OK);

    }







}
