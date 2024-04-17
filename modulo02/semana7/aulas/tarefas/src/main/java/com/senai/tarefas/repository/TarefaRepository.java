package com.senai.tarefas.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.senai.tarefas.model.Status;
import com.senai.tarefas.model.Tarefa;

@Repository
public class TarefaRepository {
  
  //Simula uma coleção de dados do banco
  private List<Tarefa> lista = new ArrayList<Tarefa>();

  private int geradorDeId = 1;

  //consultar tarefas
  public List<Tarefa> consultar() {
    return lista;
  }
  
  //Optinal.of adiciona uma tarefa dentro
  //obter tarefa por id
  public Optional<Tarefa> obter(Integer id) {
    for(var tarefa : lista) {
      if (tarefa.getId().intValue() == id.intValue()) {
        return Optional.of(tarefa);
      }
    }
    //se não encontrar uma tarefa, retorna vazio.
    return Optional.empty();
  }

  public Tarefa adicionar(Tarefa tarefa) {
    tarefa.setId(geradorDeId++);
    tarefa.setStatus(Status.PENDENTE);
    lista.add(tarefa);
    return tarefa;
  }

  public void atualizar(Tarefa atualizada) {
    List<Tarefa> nova = new ArrayList<>();
    for(var tarefa : lista){
      if (tarefa.getId().intValue() == atualizada.getId().intValue()) {
        nova.add(atualizada);
      } else {
        nova.add(tarefa);
      }
    }
    this.lista = nova;
    // --- A duas linhas abaixo (programação funcional) equivalem a toda a lógica acima --- 
    // lista.removeIf(t -> t.getId().intValue() == atualizada.getId().intValue());
    // lista.add(atualizada);
  }

  public void excluir(Tarefa tarefaExcluida) {
    // lista.removeIf(t -> t.getId().intValue() == tarefaExcluida.getId().intValue();

    List<Tarefa> nova = new ArrayList<>();
    for(var tarefa : lista) {
      if (tarefa.getId().intValue() == tarefaExcluida.getId().intValue())
        //se conincidir o id a gente da um continue para pular a tarefa
        continue;
      //se não a gente adiciona a tarefa que estava em nova, para que continue igual
      nova.add(tarefa);
    }
    this.lista = nova;



  }

}
