package com.senai.herois.repository;

import java.util.ArrayList;
import java.util.List;

import com.senai.herois.model.Heroi;

public class HeroiRepository {
  private List<Heroi> herois = new ArrayList<>();

  public List<Heroi> consultar() {
    return herois;
  }
  
}
