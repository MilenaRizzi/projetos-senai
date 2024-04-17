package com.senai.herois.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.herois.model.Heroi;
import com.senai.herois.repository.HeroiRepository;

@Service
public class HeroiService {
  
  @Autowired
  private HeroiRepository heroiRepository;
  
  public Heroi inserir(Heroi heroi) {
    if (heroiRepository.existeHeroiComNome(heroi.getNome())) {
      throw new IllegalArgumentException("Ja existe um heroi com o mesmo nome");
  }
    heroi = heroiRepository.adicionar(heroi);
    return heroi;
  }
  
  public List<Heroi> consultar() {
    return heroiRepository.consultar();
  }

}
