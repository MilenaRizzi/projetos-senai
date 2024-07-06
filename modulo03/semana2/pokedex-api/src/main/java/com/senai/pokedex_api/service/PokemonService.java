package com.senai.pokedex_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pokedex_api.exceptions.RegistroExistenteException;
import com.senai.pokedex_api.model.Pokemon;
import com.senai.pokedex_api.repository.PokemonRepository;

@Service
public class PokemonService {
  
  @Autowired
  private PokemonRepository repository;

  public void cadastrarVisto(Pokemon pokemon) {
    boolean existe = repository.existsById(pokemon.getNumero());
    if (existe) {
      throw new RegistroExistenteException("Pokemon com número já cadastrado");
    }
    repository.save(pokemon);
  }

  public void cadastrarCapturado (Pokemon pokemon) {
    Optional<Pokemon> existente = repository.findById(pokemon.getNumero());
    if (existente.isPresent()) {
      Pokemon pokemonExistente = existente.get();
      if (pokemonExistente.isCapturado()) {
        throw new RegistroExistenteException("Pokemon com número já cadastrado e capturado");
      } else {
        pokemonExistente.setCapturado(pokemon.isCapturado());
        repository.save(pokemonExistente);
      }
    } else {
      repository.save(pokemon);
    }
  }

   public boolean atualiza(Pokemon pokemon) {
    if (repository.existsById(pokemon.getNumero())) {
      repository.save(pokemon);
      return true;
    } else {
      return false;
    }
  }

  public void exclui(Integer numero) {
    repository.deleteById(numero);
  }

  public Optional<Pokemon> busca(Integer numero) {
    return repository.findById(numero);
  }

  public List<Pokemon> buscaTodos() {
    return repository.findAll();
  }

}
