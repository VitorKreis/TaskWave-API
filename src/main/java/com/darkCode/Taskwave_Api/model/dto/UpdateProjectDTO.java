package com.darkCode.Taskwave_Api.model.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateProjectDTO(
        String name,
        String description
) {
}
