package com.darkCode.Taskwave_Api.model.dto;

import com.darkCode.Taskwave_Api.model.Role;
import com.darkCode.Taskwave_Api.model.User;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email, String password, Role role) {
    public UserResponse(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPasswoard(), user.getRole());

    }

}
