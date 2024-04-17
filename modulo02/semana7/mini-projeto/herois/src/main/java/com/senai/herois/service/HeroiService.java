package com.senai.herois.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.herois.model.Heroi;
import com.senai.herois.repository.HeroiRepository;

public class HeroiService {
  
  @Autowired
  private HeroiRepository heroiRepository;
  
  public Heroi inserir(Heroi heroi) {
    heroi = heroiRepository.adicionar(heroi);
    return heroi;
  }
  
  public List<Heroi> consultar() {
    return heroiRepository.consultar();
  }

}
