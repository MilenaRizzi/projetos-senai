package com.senai.imobiliaria.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_ROLE")
@Data
public class Role {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_role;
    private String name;
}
