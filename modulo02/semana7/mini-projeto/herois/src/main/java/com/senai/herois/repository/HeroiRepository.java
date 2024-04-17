package com.senai.herois.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.senai.herois.model.Heroi;

@Repository
public class HeroiRepository {
  private List<Heroi> herois = new ArrayList<>();
  
  public Heroi adicionar(Heroi heroi) {
    herois.add(heroi);
    return heroi;
  }

  public List<Heroi> consultar() {
    return herois;
  }
  
  public boolean existeHeroiComNome(String nome) {
    return herois.stream().anyMatch(heroi -> heroi.getNome().equals(nome));
  }
}
