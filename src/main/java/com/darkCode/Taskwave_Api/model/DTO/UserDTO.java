package com.darkCode.Taskwave_Api.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank(message = "Name cannot be empity")
        String name,
        @NotBlank(message = "Email cannot be empity")
        @Email(message = "Email invalid")
        String email,
        @Size(min = 6, message = "Password must be at least 6 characters")
        @NotBlank(message = "Email cannot be empity")
        String password) {

}
