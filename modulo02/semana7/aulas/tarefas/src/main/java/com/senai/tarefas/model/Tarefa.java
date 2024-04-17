package com.senai.tarefas.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Tarefa {
  private Integer id;
  private String descricao;

  //a data será string e mostrada no formato que eu determinar - se eu não especificar nada, por padrão será mostrada a data no formato americano yyyy-MM-dd
  //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
  private LocalDate dataEntrega;
  private LocalDate dataInicio;
  private String responsavel;
  private Status status;
  private Prioridade prioridade;
  
  public Tarefa() {

  }
  
  public Tarefa(String descricao, LocalDate dataEntrega, LocalDate dataInicio, String responsavel,
      Prioridade prioridade) {
        this(descricao, dataEntrega, dataInicio, responsavel, null, prioridade);
  }

  public Tarefa(String descricao, LocalDate dataEntrega, LocalDate dataInicio, String responsavel, Status status,
      Prioridade prioridade) {
    this.descricao = descricao;
    this.dataEntrega = dataEntrega;
    this.dataInicio = dataInicio;
    this.responsavel = responsavel;
    this.status = status;
    this.prioridade = prioridade;
  }

  
}
