package com.darkCode.Taskwave_Api.model.repository;

import com.darkCode.Taskwave_Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


}
