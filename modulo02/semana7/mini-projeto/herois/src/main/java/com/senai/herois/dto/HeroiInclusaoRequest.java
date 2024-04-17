package com.senai.herois.dto;

public class HeroiInclusaoRequest {
  private String nome;
  private String superpoder;
  private Integer idade;
  private String cidade;

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
