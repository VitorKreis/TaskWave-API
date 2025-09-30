package com.darkCode.Taskwave_Api.model.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProjectDTO(
        @NotNull
        String name,
        String description,
        @NotNull
        UUID responsavel,
        UUID user) {
}
