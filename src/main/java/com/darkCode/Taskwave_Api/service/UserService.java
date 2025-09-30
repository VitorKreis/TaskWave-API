package com.darkCode.Taskwave_Api.service;


import com.darkCode.Taskwave_Api.model.Role;
import com.darkCode.Taskwave_Api.model.User;
import com.darkCode.Taskwave_Api.model.dto.UpdataUserDTO;
import com.darkCode.Taskwave_Api.model.dto.UserDTO;
import com.darkCode.Taskwave_Api.model.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(UserDTO user){
        var User = new User(user);

        User.setRole(Role.USER);

        repository.save(User);

        return User;
    }


    public User getOne(UUID id){

        return repository.getReferenceById(id);
    }


    public List<User> getAll(){
        return repository.findAll();
    }


    public User update(UpdataUserDTO body, UUID id) throws Exception {

        var user = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));


        if (body.name() != null && !body.name().isBlank()) {
            user.setName(body.name());
        }

        if (body.role() != null) {
            user.setRole(body.role());
        }

        if (body.email() != null && !body.email().isBlank()) {
            user.setEmail(body.email());
        }


        return repository.save(user);

    }



    public void delete(UUID id){
        var user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        repository.delete(user);
    }


}
