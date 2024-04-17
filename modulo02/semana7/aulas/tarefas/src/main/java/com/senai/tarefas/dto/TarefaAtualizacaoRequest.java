package com.senai.tarefas.dto;

import java.time.LocalDate;

import com.senai.tarefas.model.Prioridade;
import com.senai.tarefas.model.Status;

import lombok.Data;

@Data
public class TarefaAtualizacaoRequest { 
  private String descricao;
  private LocalDate dataEntrega;
  private LocalDate dataInicio;
  private String responsavel;
  private Status status;
  private Prioridade prioridade;
}
