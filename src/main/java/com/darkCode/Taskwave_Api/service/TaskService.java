package com.darkCode.Taskwave_Api.service;

import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository repository;


    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public List<Task> getAll(){
        return repository.findAll();
    }

    public Task create(Task task){
        var Task = task;
        Task.setDone(false);
        return repository.save(Task);
    }


    public Task update(String id) throws Exception {
        var task = repository.findById(id);

        if(!task.isPresent()){
            throw new Exception("Task com esse id nao encontrada!!");
        }

        task.get().setDone(true);
        repository.save(task.get());

        return task.get();
    }


    public void delete(String id) throws Exception {
        var task = repository.findById(id);

        if(!task.isPresent()){
            throw new Exception("Task com esse id nao encontrada!!");
        }

        repository.delete(task.get());

    }
}
