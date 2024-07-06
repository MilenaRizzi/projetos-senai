package com.senai.pokedex_api.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.senai.pokedex_api.dtos.PokemonAtualizadoDTO;
import com.senai.pokedex_api.dtos.PokemonCapturadoDTO;
import com.senai.pokedex_api.dtos.PokemonPreviewDTO;
import com.senai.pokedex_api.dtos.PokemonVistoDTO;
import com.senai.pokedex_api.model.Pokemon;
import com.senai.pokedex_api.service.PokemonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

  @Autowired
  private PokemonService service;

  @Autowired
  private ModelMapper mapper;

  @PostMapping("/visto")
  public ResponseEntity<Void> cadastraVisto(@RequestBody @Valid PokemonVistoDTO pokemonVisto) {
    Pokemon pokemon = mapper.map(pokemonVisto, Pokemon.class);
    service.cadastrarVisto(pokemon);
    return ResponseEntity.created(URI.create(String.format("/%d", pokemonVisto.getNumero())))
        .build();
  }

  @PostMapping("/capturado")
  public ResponseEntity<Void> cadastrarCapturado(@RequestBody @Valid PokemonCapturadoDTO pokemonCapturado) {
    Pokemon pokemon = mapper.map(pokemonCapturado, Pokemon.class);
    service.cadastrarCapturado(pokemon);
    return ResponseEntity.created(URI.create(String.format("/%d", pokemonCapturado.getNumero())))
        .build();
  }

  @PutMapping
  public ResponseEntity<Void> atualiza(
      @Valid @RequestBody PokemonAtualizadoDTO pokemonAtualizadoDTO) {
    Pokemon pokemon = mapper.map(pokemonAtualizadoDTO, Pokemon.class);
    return service.atualiza(pokemon)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{numero}")
  public ResponseEntity<Void> exclui(@PathVariable Integer numero) {
    service.exclui(numero);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{numero}")
  public ResponseEntity<Pokemon> busca(@PathVariable Integer numero) {
    return service
        .busca(numero)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<PokemonPreviewDTO>> buscaTodos() {
    var pokemons = service.buscaTodos();
    var resp = pokemons.stream().map(pokemon -> mapper.map(pokemon, PokemonPreviewDTO.class)).toList();;
    return ResponseEntity.ok().body(resp);
  }
}
