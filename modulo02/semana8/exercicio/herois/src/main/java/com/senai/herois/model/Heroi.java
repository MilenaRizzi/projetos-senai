package com.senai.herois.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "herois")
public class Heroi {

  @Id
  @Column(length = 20, nullable = false)
  private String nome;

  @Column(length = 40, nullable = false)
  private String superpoder;

  @Column(nullable = true)
  private Integer idade;

  @Column(length = 100, nullable = true)
  private String cidade;

  public Heroi() {
  }

  public Heroi(String nome, String superpoder, Integer idade, String cidade) {
    this.nome = nome;
    this.superpoder = superpoder;
    this.idade = idade;
    this.cidade = cidade;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSuperpoder() {
    return this.superpoder;
  }

  public void setSuperpoder(String superpoder) {
    this.superpoder = superpoder;
  }

  public Integer getIdade() {
    return this.idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

}