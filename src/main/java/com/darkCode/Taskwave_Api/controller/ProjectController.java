package com.darkCode.Taskwave_Api.controller;


import com.darkCode.Taskwave_Api.model.Project;
import com.darkCode.Taskwave_Api.model.dto.ProjectDTO;
import com.darkCode.Taskwave_Api.model.dto.UpdateProjectDTO;
import com.darkCode.Taskwave_Api.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("project")
public class ProjectController {


    private ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDTO body, UriComponentsBuilder uriComponentsBuilder){
        var response = service.create(body);

        var uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }


    @GetMapping
    public ResponseEntity<List<Project>> getAll(){

        var response = service.getAll();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Project> getOne(@PathVariable UUID id){
        var response = service.getOne(id);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable UUID id, @RequestBody UpdateProjectDTO body){

        var res = service.update(id, body);

        return ResponseEntity.ok(res);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        service.delete(id);

        return ResponseEntity.ok("Projeto deletado com sucesso");
    }



}
