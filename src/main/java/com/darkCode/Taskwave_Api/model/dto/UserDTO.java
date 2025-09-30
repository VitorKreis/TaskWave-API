package com.darkCode.Taskwave_Api.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotNull
        String name,
        @NotNull
        @Email
        String email,
        @NotNull
        @Size(min = 8)
        String passwoard
) {
}
