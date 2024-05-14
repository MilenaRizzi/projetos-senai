package com.senai.imobiliaria.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.imobiliaria.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    User findByUsername(String username);

    @Query("SELECT user FROM User user JOIN FETCH user.roles WHERE user.username = :username")
    User findByUsernameFetchRoles(@Param("username") String username);
}
