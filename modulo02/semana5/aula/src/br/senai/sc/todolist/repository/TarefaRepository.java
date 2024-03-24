package br.senai.sc.todolist.repository;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.todolist.exception.TarefaException;
import br.senai.sc.todolist.model.Tarefa;

//Classe repository lida com a persistencia e recuperação de dados - conversa com o banco
public class TarefaRepository {
  // lista deixada em memória para simular o banco
  private List<Tarefa> tarefas = new ArrayList<>();
  private int identificador = 0;

  public void gravar(Tarefa tarefa) {
    tarefa.setId(++identificador);
    tarefas.add(tarefa);
  }

  public List<Tarefa> consultar() {
    return tarefas;
  }

  public void excluir(int id) {
    // crio uma lista vazia
    List<Tarefa> atualizadas = new ArrayList<>();

    // PROGRAMAÇÃO ITERATIVA
    // itero sobre as tarefas que estão cadastradas
    for (Tarefa tarefa : tarefas) {
      // se não for a tarefa que eu quero apagar, então eu vou copiar a tarefa para a
      // lista de atualizadas
      if (tarefa.getId() != id) {
        atualizadas.add(tarefa);
      }
      // e a lista de tarefas anterior recebe a lista de tarefas atualizadas
      tarefas = atualizadas;

      /*
       * programaçao funcional
       * tarefas.removeIf(t -> t.getId() != id);
       */
    }
  }

  public Tarefa consultarPorId(int id) {
    for (Tarefa tarefa : tarefas) {
      if (tarefa.getId() == id) {
        return tarefa;
      }
    }
    return null;
    //paradigma funcional
    // return tarefas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
  }

  public void marcarComoConcluida(int id) throws TarefaException {
    boolean atualizou = false;
    for (Tarefa tarefa : tarefas) {
      if (tarefa.getId() == id) {
        tarefa.setConcluida(true);
        atualizou = true;
      }
    }

    if (!atualizou) {
      throw new TarefaException("Tarefa com id não localizado");
    }
  }
}
