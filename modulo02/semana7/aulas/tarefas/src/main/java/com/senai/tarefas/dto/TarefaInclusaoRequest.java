package com.senai.tarefas.dto;

import java.time.LocalDate;

import com.senai.tarefas.model.Prioridade;

import lombok.Data;

@Data
public class TarefaInclusaoRequest { 
  private String descricao;
  private LocalDate dataEntrega;
  private LocalDate dataInicio;
  private String responsavel;
  private Prioridade prioridade;
}
