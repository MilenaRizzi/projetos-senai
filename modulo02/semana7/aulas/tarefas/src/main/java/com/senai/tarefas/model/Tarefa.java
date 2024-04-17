package com.senai.tarefas.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Tarefa {
  private Integer id;
  private String descricao;

  //a data será string e mostrada no formato que eu determinar - se eu não especificar nada, por padrão será mostrada a data no formato americano yyyy-MM-dd
  //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
  private LocalDate dataEntrega;
  private LocalDate dataInicio;
  private Status status;
  private Prioridade prioridade;
}
