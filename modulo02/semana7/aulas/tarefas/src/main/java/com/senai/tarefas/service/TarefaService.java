package com.senai.tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.tarefas.exception.RegistroNaoEncontradoException;
import com.senai.tarefas.model.Tarefa;
import com.senai.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {


  @Autowired
  private TarefaRepository repository;
  
  public List<Tarefa> consultar() {
    return repository.consultar();
  }
  
  public Tarefa consultar(Integer id) {
    var tarefaOpt = repository.obter(id);
    // if (tarefaOpt.isPresent()) {
    //   return tarefaOpt.get();
    // } else {
    //   throw new RegistroNaoEncontradoException();
    // }
    return tarefaOpt.orElseThrow(() -> new RegistroNaoEncontradoException());
  }

  public Tarefa inserir(Tarefa tarefa) {
    tarefa = repository.adicionar(tarefa);
    return tarefa;
  }

  public Tarefa alterar(Tarefa tarefaAtualizada) {
    var tarefaOpt = repository.obter(tarefaAtualizada.getId());
    var tarefa = tarefaOpt.orElseThrow(() -> new RegistroNaoEncontradoException()
    );
    tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
    tarefa.setDataInicio(tarefa.getDataInicio());
    tarefa.setDescricao(tarefaAtualizada.getDescricao());
    tarefa.setPrioridade(tarefaAtualizada.getPrioridade());
    tarefa.setStatus(tarefaAtualizada.getStatus());
    repository.atualizar(tarefa);
    return tarefa;
  }

  public void excluirTarefa(Integer id) {
    var tarefaOpt = repository.obter(id);
    var tarefa = tarefaOpt.orElseThrow(() -> new RegistroNaoEncontradoException());
    repository.excluir(tarefa);
  }

}
