package com.darkCode.Taskwave_Api.model;

import jakarta.persistence.*;
import jdk.jfr.Timespan;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "resposible_id")
    private Users resposible;


    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Users> users_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getResposible() {
        return resposible;
    }

    public void setResposible(Users resposible) {
        this.resposible = resposible;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<Users> getUsers_id() {
        return users_id;
    }

    public void setUsers_id(List<Users> users_id) {
        this.users_id = users_id;
    }
}
