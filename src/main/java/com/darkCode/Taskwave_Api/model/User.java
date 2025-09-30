package com.darkCode.Taskwave_Api.model;


import com.darkCode.Taskwave_Api.model.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;


import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "passwoard")
    private String passwoard;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    public User(UserDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.passwoard = dto.passwoard();
    }

    protected User() {
    }
}
