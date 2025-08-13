package com.darkCode.Taskwave_Api.repository;

import com.darkCode.Taskwave_Api.model.DTO.LoginDTO;
import com.darkCode.Taskwave_Api.model.Task;
import com.darkCode.Taskwave_Api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
