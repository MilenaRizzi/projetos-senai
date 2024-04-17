package com.senai.tarefas.dto;

import java.time.LocalDate;

import com.senai.tarefas.model.Prioridade;
import com.senai.tarefas.model.Status;
import com.senai.tarefas.model.Tarefa;

import lombok.Data;

@Data
public class TarefaResponse {
  private Integer id;
  private String descricao;
  private LocalDate dataEntrega;
  private LocalDate dataInicio;
  private String responsavel;
  private Status status;
  private Prioridade prioridade;
  
  //não tem problema o meu DTO conhecer o meu objeto de modelo, mas nao fazer sentindo o meu objeto de modelo conhecer um objeto response. 
  public TarefaResponse(Tarefa tarefa) {
    this.id = tarefa.getId();
    this.descricao = tarefa.getDescricao();
    this.dataEntrega = tarefa.getDataEntrega();
    this.dataInicio = tarefa.getDataInicio();
    this.responsavel = tarefa.getResponsavel();
    this.status = tarefa.getStatus();
    this.prioridade = tarefa.getPrioridade();
  }
}
