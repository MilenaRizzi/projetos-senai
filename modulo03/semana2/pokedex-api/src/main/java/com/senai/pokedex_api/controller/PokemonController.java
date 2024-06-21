package com.senai.pokedex_api.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pokedex_api.dtos.PokemonCapturadoDTO;
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
}
