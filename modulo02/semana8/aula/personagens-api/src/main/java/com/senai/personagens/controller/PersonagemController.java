package com.senai.personagens.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.personagens.model.Personagem;
import com.senai.personagens.service.PersonagemService;

@RestController
@RequestMapping("personagens")
public class PersonagemController {

  @Autowired
  private PersonagemService personagemService;

  @GetMapping
  public ResponseEntity<List<Personagem>> listar(
      @RequestParam(required = false) String nome,
      @RequestParam(required = false) String referencia) {
    List<Personagem> personagens = new ArrayList<>();
    //se os query params não forem passados, então o retorno será todos os personagens
    if (nome == null && referencia == null) {
      personagens = personagemService.consultar();
    } else if (nome != null && referencia == null) {
      //se o nome não for vazio então se consulta por nome
      Personagem personagem = personagemService.consultarPorNome(nome);
      personagens.add(personagem);
    } else {
      Personagem personagem = personagemService.consultarPor(nome, referencia);
      personagens.add(personagem);
    }
    return ResponseEntity.ok().body(personagens);
  }

  @GetMapping("{id}")
  public ResponseEntity<Personagem> consultarPorCodigo(@PathVariable Integer id) {
    var personagem = personagemService.consultar(id);
    return ResponseEntity.ok().body(personagem);
  }

  @PostMapping
  public ResponseEntity<Personagem> criar(@RequestBody Personagem personagem) {
    personagemService.inserir(personagem);
    return ResponseEntity.created(URI.create(personagem.getId().toString())).body(personagem);
  }

  @PutMapping("{id}")
  public ResponseEntity<Personagem> atualizar(@PathVariable Integer id, @RequestBody Personagem personagem) {
    personagem.setId(id);
    personagemService.atualizar(personagem);
    return ResponseEntity.ok().body(personagem);
  }

  // aqui no delete não vai ser devolvido nada, então eu posso colocar a ? que é
  // como se fosse um void.
  // pode-se também colocar um object, porém o object da a entender que algo será
  // retornado.
  @DeleteMapping("{id}")
  public ResponseEntity<?> excluir(@PathVariable Integer id) {
    personagemService.excluir(id);
    // se o delete der certo ele me retorna um 204 que o código do nocontent
    return ResponseEntity.noContent().build();
  }
}
