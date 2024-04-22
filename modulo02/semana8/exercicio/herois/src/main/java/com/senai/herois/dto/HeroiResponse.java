package com.senai.herois.dto;

import com.senai.herois.model.Heroi;

public class HeroiResponse {
  private String nome;
  private String superpoder;
  private Integer idade;
  private String cidade;


  public HeroiResponse() {
  }

  public HeroiResponse(Heroi heroi) {
    this.nome = heroi.getNome();
    this.superpoder = heroi.getSuperpoder();
    this.idade = heroi.getIdade();
    this.cidade = heroi.getCidade();
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
