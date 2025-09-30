package com.darkCode.Taskwave_Api.model.dto;

import com.darkCode.Taskwave_Api.model.Priority;
import com.darkCode.Taskwave_Api.model.Status;
import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.model.User;

public record TaskResponse(String name, String description, Priority priority, Status status, User user ) {
    public TaskResponse(Task task){
        this(task.getName(), task.getDescription(), task.getPriority(), task.getStatus(), task.getUser());
    }
}
