package com.darkCode.Taskwave_Api.model;

import com.darkCode.Taskwave_Api.model.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Task (TaskDTO dto){
        this.name = dto.name();
        this.description = dto.description();
        this.priority = dto.priority();
        this.status = Status.TO_DO;
    }

    protected Task(){}


}
