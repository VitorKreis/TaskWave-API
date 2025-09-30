package com.darkCode.Taskwave_Api.model.dto;

import com.darkCode.Taskwave_Api.model.Status;

public record UpdateTaskDTO(String name, String description, Status status) {
}
