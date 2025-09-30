package com.darkCode.Taskwave_Api.controller;


import com.darkCode.Taskwave_Api.model.User;
import com.darkCode.Taskwave_Api.model.dto.UpdataUserDTO;
import com.darkCode.Taskwave_Api.model.dto.UserDTO;
import com.darkCode.Taskwave_Api.model.dto.UserResponse;
import com.darkCode.Taskwave_Api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping

    public ResponseEntity<User> create(@RequestBody UserDTO user, UriComponentsBuilder uriComponentsBuilder){
        var res = service.create(user);

        var uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(res.getId()).toUri();

        return ResponseEntity.created(uri).body(res);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getOne(@PathVariable UUID id){

        var res = service.getOne(id);

        return ResponseEntity.ok(new UserResponse(res));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAll(){

        var res = service.getAll();

        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UpdataUserDTO body, @PathVariable UUID id) throws Exception {

        var res = service.update(body, id);

        return ResponseEntity.ok(res);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){

        service.delete(id);

        return ResponseEntity.ok("Usuario deletado");
    }







}
