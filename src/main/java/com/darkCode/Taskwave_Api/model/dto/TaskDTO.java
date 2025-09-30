package com.darkCode.Taskwave_Api.model.dto;

import com.darkCode.Taskwave_Api.model.Priority;
import com.darkCode.Taskwave_Api.model.User;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TaskDTO(

        @NotNull
        String name,
        @NotNull
        String description,
        @NotNull
        Priority priority,
        @NotNull
        UUID user

) {
}
