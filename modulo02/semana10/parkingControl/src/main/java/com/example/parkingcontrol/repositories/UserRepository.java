package com.example.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkingcontrol.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);

    @Query("SELECT user FROM UserModel user JOIN FETCH user.roles WHERE user.username = :username")
    UserModel findByUsernameFetchRoles(@Param("username") String username);
}
