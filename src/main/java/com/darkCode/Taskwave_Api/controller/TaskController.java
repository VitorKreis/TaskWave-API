package com.darkCode.Taskwave_Api.controller;


import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.model.dto.TaskDTO;
import com.darkCode.Taskwave_Api.model.dto.TaskResponse;
import com.darkCode.Taskwave_Api.model.dto.UpdateTaskDTO;
import com.darkCode.Taskwave_Api.model.repository.TaskRepositoy;
import com.darkCode.Taskwave_Api.service.TaskService;
import jakarta.validation.GroupSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task")
public class TaskController {

    TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDTO task, UriComponentsBuilder uriComponentsBuilder){

        var res = service.create(task);

        var uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(res.getId()).toUri();

        return ResponseEntity.created(uri).body(res);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){

        var res = service.getAll();

        return ResponseEntity.ok(res);

    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getOne(@PathVariable UUID id){

        var res = service.getOne(id);

        return ResponseEntity.ok(new TaskResponse(res));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable UUID id, @RequestBody UpdateTaskDTO body){

        var res = service.update(id, body);

        return ResponseEntity.ok(new TaskResponse(res));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        service.delete(id);

        return ResponseEntity.ok("Task deletada com sucesso");
    }






}
