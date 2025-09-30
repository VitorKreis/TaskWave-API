package com.darkCode.Taskwave_Api.model.dto;

import com.darkCode.Taskwave_Api.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UpdataUserDTO(
        String name,
        @Email
        String email,
        Role role
) {
}
