package com.darkCode.Taskwave_Api.service;


import com.darkCode.Taskwave_Api.model.DTO.LoginDTO;
import com.darkCode.Taskwave_Api.model.DTO.UserDTO;
import com.darkCode.Taskwave_Api.model.Users;
import com.darkCode.Taskwave_Api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {

        this.repository = repository;
    }

    public Users create(UserDTO user){
        var users = new Users(user);

        repository.save(users);

        return users;

    }

    public List<Users> GetAll(){
        return repository.findAll();
    }

    public Users GetByID(Long id){
        return repository.findById(id).get();
    }


    public Users update(Long id, UserDTO user){
        var User = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));


        User.setName(user.name());
        User.setEmail(user.email());
        if(!Objects.equals(User.getPassword_hash(), user.password())){
            User.setPassword_hash(user.password());
        }

        repository.save(User);

        return User;
    }


    public void delete(Long id){
        repository.deleteById(id);
    }


    public Optional<Users> login(LoginDTO login) throws Exception {

        var user = repository.findByEmail(login.Email());

        if(user.isEmpty() || user.isPresent()){
            throw new EntityNotFoundException("Usuário não encontrado");
        }

        if(!Objects.equals(user.get().getPassword_hash(), login.Password())){
            throw new Exception("Senha nao conhecide");
        }

        return user;

    }


}
