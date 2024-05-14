package com.senai.imobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.imobiliaria.model.User;
import com.senai.imobiliaria.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User saveUser(User userModel) {
    User existUser = userRepository.findByUsername(userModel.getUsername());

    if (existUser != null) {
      throw new Error("Usuário já existe!");
    }

    userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
    return userRepository.save(userModel);
  }

  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}