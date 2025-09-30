package com.darkCode.Taskwave_Api.model;

import com.darkCode.Taskwave_Api.model.dto.ProjectDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "Project")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "project_id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "project_ativo")
    private Boolean ativo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsavel_id")
    private User responsavel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Project(ProjectDTO dto){
        this.name = dto.name();
        this.description = dto.description();
        this.ativo = Boolean.TRUE;
    }


    protected Project(){}

}
