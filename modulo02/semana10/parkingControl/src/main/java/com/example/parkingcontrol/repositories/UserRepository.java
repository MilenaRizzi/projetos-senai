package com.example.parkingcontrol.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingcontrol.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
  
  UserModel findByUserName(String userName);
}
