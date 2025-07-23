package com.darkCode.Taskwave_Api.repository;

import com.darkCode.Taskwave_Api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
