package com.senai.tarefas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tarefas.exception.RegistroNaoEncontradoException;
import com.senai.tarefas.model.Tarefa;
import com.senai.tarefas.service.TarefaService;

@RestController
@RequestMapping("tarefas")
public class TarefaController {
  
  @Autowired
  private TarefaService service;

  @GetMapping
  public ResponseEntity<List<Tarefa>> listar() {
    var tarefas = service.consultar();

    // body(tarefas) para definir o corpo da resposta como as tarefas fornecidas. Esta é uma maneira mais explícita de definir o corpo da resposta
    return ResponseEntity.ok().body(tarefas);
  }

  //atributo dinâmico - o que chegar aqui o spring vai reconhecer e capturar em pathvariable
  @GetMapping("{id}")
  public ResponseEntity<Tarefa> consultarPorId(@PathVariable Integer id) {
    try {
      //se uma tarefa foi encontrada o service vai retornar 200 de ok
      var tarefa = service.consultar(id);
      return ResponseEntity.ok(tarefa);
    } catch (RegistroNaoEncontradoException e) {
      //se cairmos na excessão é pq a tarefa de id não existe, então temos o status 404
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Tarefa> inserir(@RequestBody Tarefa tarefa) {
    tarefa = service.inserir(tarefa);
    return ResponseEntity.created(URI.create(tarefa.getId().toString())).body(tarefa);
  }

  @PutMapping("{id}")
  public ResponseEntity<Tarefa> atualizar (@PathVariable Integer id, @RequestBody Tarefa tarefaAtualizada) {
    try {
      tarefaAtualizada.setId(id);
      var tarefa = service.alterar(tarefaAtualizada);
      return ResponseEntity.ok(tarefa);
    } catch (RegistroNaoEncontradoException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> excluir(@PathVariable Integer id) {
    try {
      service.excluirTarefa(id);
      return ResponseEntity.noContent().build();
    } catch (RegistroNaoEncontradoException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
