package br.senai.sc.heroi.model;

import br.senai.sc.heroi.view.ConsoleColors;

public class Heroi {
  private String nome;
  private String superpoder;
  private Integer idade;

  public Heroi() {
  }

  public Heroi(String nome, String superpoder, Integer idade) {
    this.nome = nome;
    this.superpoder = superpoder;
    this.idade = idade;
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

  @Override
  public String toString() {
    return "Herói: " + ConsoleColors.CYAN_BOLD + getNome() + ConsoleColors.RESET +
        ", superpoder: " + ConsoleColors.CYAN_BOLD + getSuperpoder() + ConsoleColors.RESET +
        ", idade: " + ConsoleColors.CYAN_BOLD + getIdade() + ConsoleColors.RESET;
  }

}
