package com.example.parkingcontrol.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;

  @Column(nullable = false, unique = true)
  private String userName;

  @Column(nullable = false)
  private String password;

  @ManyToMany //1 usuário pode ter muitas funções / 1 função pode ter muitos usuários -> por isso manytomany 
  //quando utilizamos many to many uma tabela intermediaria tem que ser criada para fazer a relação, por isso criamos a tabela TB_USER_ROLES
  @JoinTable(name = "TB_USER_ROLES", 
  joinColumns = @JoinColumn(name = "user_id"), 
  inverseJoinColumns = @JoinColumn(name = "role_id"))
  /*Uma tabela TB_USER_ROLES foi criada, a coluna user_id dessa tabela é a chave estrangeira que referencia a tabela de usuários
   * a coluna role_id dessa tabela é a chave estrangeira que refencia a tabela de funções.
   */
  private List<RoleModel> roles;


  public UUID getUserId() {
    return this.userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<RoleModel> getRoles() {
    return this.roles;
  }

  public void setRoles(List<RoleModel> roles) {
    this.roles = roles;
  }

}
