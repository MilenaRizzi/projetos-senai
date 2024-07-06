package com.senai.pokedex_api.dtos;

public class PokemonPreviewDTO {
    private Integer numero;
    private String nome;
    private Boolean capturado;
  
    public Integer getNumero() {
      return numero;
    }
  
    public void setNumero(Integer numero) {
      this.numero = numero;
    }
  
    public String getNome() {
      return nome;
    }
  
    public void setNome(String nome) {
      this.nome = nome;
    }
  
    public Boolean getCapturado() {
      return capturado;
    }
  
    public void setCapturado(Boolean capturado) {
      this.capturado = capturado;
    }
  }
  