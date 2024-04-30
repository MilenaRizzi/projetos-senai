package com.example.parkingcontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.parkingcontrol.models.UserModel;
import com.example.parkingcontrol.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  UserRepository userRepository;


  public UserModel saveUser(UserModel userModel) {
    UserModel existUser = userRepository.findByUserName(userModel.getUserName());

    if (existUser != null) {
      throw new Error("Usuário já existe!");
    }
    //antes de armazenar usuário vamos codificar a senha
    userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
    return userRepository.save(userModel);
  }


  //método para aplica a codificação na senha do usuário
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
