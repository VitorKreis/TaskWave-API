package com.darkCode.Taskwave_Api.model.repository;

import com.darkCode.Taskwave_Api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepositoy extends JpaRepository<Task, UUID> {
}
