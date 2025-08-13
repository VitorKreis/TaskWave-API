package com.darkCode.Taskwave_Api.controller;


import com.darkCode.Taskwave_Api.model.DTO.LoginDTO;
import com.darkCode.Taskwave_Api.model.DTO.UserDTO;
import com.darkCode.Taskwave_Api.model.Users;
import com.darkCode.Taskwave_Api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }



    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UserDTO user){

        var response = service.create(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Users>> GetAll(){
        var response = service.GetAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Users> GetByID(@PathVariable Long id){
        var response = service.GetByID(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody UserDTO user){
        var response = service.update(id, user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO login) throws Exception {
        var response = service.login(login);

        return new ResponseEntity("Login feito com Sucesso", HttpStatus.OK);
    }




}
