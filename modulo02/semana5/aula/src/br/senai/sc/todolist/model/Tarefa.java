package br.senai.sc.todolist.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
   private Integer id;
  private String texto;
  private boolean concluida;
  private LocalDateTime dataCriação;
    
  public Tarefa() {
    this.dataCriação = LocalDateTime.now();
  }

      
  public Tarefa(String texto) {
    this();
    this.texto = texto;
  }

  public Tarefa(Integer id, String texto, boolean concluida, LocalDateTime dataCriação) {
    this.id = id;
    this.texto = texto;
    this.concluida = concluida;
    this.dataCriação = dataCriação;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTexto() {
    return this.texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public boolean isConcluida() {
    return this.concluida;
  }

  public boolean getConcluida() {
    return this.concluida;
  }

  public void setConcluida(boolean concluida) {
    this.concluida = concluida;
  }

  public LocalDateTime getDataCriação() {
    return this.dataCriação;
  }

  public void setDataCriação(LocalDateTime dataCriação) {
    this.dataCriação = dataCriação;
  }

  @Override
  public String toString() {
    return "Tarefa " +
      " id= " + id +
      ", texto= " + texto +
      ", concluida= " + (concluida ? "sim" : "não") +
      ", dataCriação= " + dataCriação.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }
  
}
