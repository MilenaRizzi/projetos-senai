package com.senai.tarefas.controller;

import java.net.URI;
import java.util.ArrayList;
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

import com.senai.tarefas.dto.TarefaAtualizacaoRequest;
import com.senai.tarefas.dto.TarefaInclusaoRequest;
import com.senai.tarefas.dto.TarefaResponse;
import com.senai.tarefas.exception.RegistroNaoEncontradoException;
import com.senai.tarefas.model.Tarefa;
import com.senai.tarefas.service.TarefaService;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

  @Autowired
  private TarefaService service;

  @GetMapping
  public ResponseEntity<List<TarefaResponse>> listar() {
    var tarefas = service.consultar();
    var resp = new ArrayList<TarefaResponse>();
    for (var tarefa : tarefas) {
      resp.add(new TarefaResponse(tarefa));
    }
    // body(tarefas) para definir o corpo da resposta como as tarefas fornecidas.
    // Esta é uma maneira mais explícita de definir o corpo da resposta
    return ResponseEntity.ok().body(resp);
  }

  // atributo dinâmico - o que chegar aqui o spring vai reconhecer e capturar em
  // pathvariable
  @GetMapping("{id}")
  public ResponseEntity<TarefaResponse> consultarPorId(@PathVariable Integer id) {
    try {
      // se uma tarefa foi encontrada o service vai retornar 200 de ok
      var tarefa = service.consultar(id);
      var resp = new TarefaResponse(tarefa);
      return ResponseEntity.ok(resp);
    } catch (RegistroNaoEncontradoException e) {
      // se cairmos na excessão é pq a tarefa de id não existe, então temos o status
      // 404
      return ResponseEntity.notFound().build();
    }
  }

  // Boa prática -> o controller tem que isolar a minha aplicação do mundo externo
  // ele não poderia deixar vazar um request para dentro de service
  // não deixar informações http (request) vazar para dentro da camada de serviço
  // cujo a responsabilidade é tratar regras de negócio.
  @PostMapping
  public ResponseEntity<TarefaResponse> inserir(@RequestBody TarefaInclusaoRequest request) {
    // modelmapper biblioteca
    var tarefa = new Tarefa(request.getDescricao(), request.getDataEntrega(), request.getDataInicio(),
        request.getResponsavel(), request.getPrioridade());

    tarefa = service.inserir(tarefa);
    var resp = new TarefaResponse(tarefa);
    return ResponseEntity.created(URI.create(tarefa.getId().toString())).body(resp);
  }

  @PutMapping("{id}")
  public ResponseEntity<TarefaResponse> atualizar(@PathVariable Integer id, @RequestBody TarefaAtualizacaoRequest request) {
    try {
      var tarefa = new Tarefa(request.getDescricao(), request.getDataEntrega(),
          request.getDataInicio(), request.getResponsavel(), request.getStatus(),
          request.getPrioridade());
      tarefa.setId(id);
      tarefa = service.alterar(tarefa);
      //não é uma boa prática voltar o objeto de modelo (Tarefa) nos meus serviços da API, por isso criamos um DTO tarefa response
      var resp = new TarefaResponse(tarefa);
      return ResponseEntity.ok(resp);
    } catch (RegistroNaoEncontradoException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> excluir(@PathVariable Integer id) {
    try {
      service.excluirTarefa(id);
      // no content -> 204
      return ResponseEntity.noContent().build();
    } catch (RegistroNaoEncontradoException e) {
      // not found -> 404
      return ResponseEntity.notFound().build();
    }
  }
}
