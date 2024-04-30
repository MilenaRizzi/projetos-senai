package com.example.parkingcontrol.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((request) -> request
                .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/parking-spot/**")
                .anyRequest()
                .authenticated());
    return http.build();
  }

}
