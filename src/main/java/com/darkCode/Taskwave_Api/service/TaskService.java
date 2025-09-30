package com.darkCode.Taskwave_Api.service;

import com.darkCode.Taskwave_Api.model.Status;
import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.model.dto.TaskDTO;
import com.darkCode.Taskwave_Api.model.dto.UpdateTaskDTO;
import com.darkCode.Taskwave_Api.model.repository.TaskRepositoy;
import com.darkCode.Taskwave_Api.model.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    TaskRepositoy repositoy;

    UserRepository userRepository;

    public TaskService(TaskRepositoy repositoy, UserRepository userRepository) {
        this.repositoy = repositoy;
        this.userRepository = userRepository;
    }


    public Task create(TaskDTO body){
        var task = new Task(body);

        var user = userRepository.findById(body.user())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + body.user()));

        task.setUser(user);

        repositoy.save(task);

        return task;
    }


    public List<Task> getAll(){
        return repositoy.findAll();
    }

    public Task getOne(UUID id){
        return repositoy.getReferenceById(id);
    }


    public Task update(UUID id, UpdateTaskDTO taskDTO){
        var task = repositoy.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));


        task.setName(taskDTO.name());
        task.setDescription(taskDTO.description());
        task.setStatus(taskDTO.status());


        return repositoy.save(task);
    }


    public void delete(UUID id){
        repositoy.deleteById(id);
    }





}
