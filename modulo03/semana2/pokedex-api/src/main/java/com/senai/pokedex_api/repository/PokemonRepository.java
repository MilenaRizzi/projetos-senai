package com.senai.pokedex_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.pokedex_api.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{
  
}
