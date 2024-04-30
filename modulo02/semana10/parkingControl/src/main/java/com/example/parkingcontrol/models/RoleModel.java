package com.example.parkingcontrol.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id_role;

  private String name;


  public UUID getId_role() {
    return this.id_role;
  }

  public void setId_role(UUID id_role) {
    this.id_role = id_role;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
