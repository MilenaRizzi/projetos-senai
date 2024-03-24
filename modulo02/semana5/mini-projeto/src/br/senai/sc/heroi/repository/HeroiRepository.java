package br.senai.sc.heroi.repository;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.heroi.model.Heroi;

public class HeroiRepository {
  private List<Heroi> herois = new ArrayList<>();

  public void adicionar(Heroi heroi) {
    herois.add(heroi);
  }

  public List<Heroi> consultar() {
    return herois;
  }
}
