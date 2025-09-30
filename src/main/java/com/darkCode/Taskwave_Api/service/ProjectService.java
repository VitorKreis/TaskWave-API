package com.darkCode.Taskwave_Api.service;

import com.darkCode.Taskwave_Api.model.Project;
import com.darkCode.Taskwave_Api.model.dto.ProjectDTO;
import com.darkCode.Taskwave_Api.model.dto.UpdateProjectDTO;
import com.darkCode.Taskwave_Api.model.repository.ProjectRepository;
import com.darkCode.Taskwave_Api.model.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private ProjectRepository repository;

    private UserRepository userRepository;

    public ProjectService(ProjectRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }


    public Project create(ProjectDTO body){

        var project = new Project(body);

        var responsavel = userRepository.findById(body.responsavel())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + body.user()));
        project.setResponsavel(responsavel);

        var user = userRepository.findById(body.user())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + body.user()));
        project.setUser(user);

        return repository.save(project);
    }


    public List<Project> getAll(){
        return repository.findAll();
    }

    public Project getOne(UUID id){

        var res = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        return res;
    }

    public Project update(UUID id, UpdateProjectDTO body){
        var project = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        project.setName(body.name());
        project.setDescription(body.description());

        return repository.save(project);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }





}
