package com.senai.herois.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.herois.model.Heroi;
import com.senai.herois.service.HeroiService;

@RestController
@RequestMapping
public class HeroiController {
  
  @Autowired
  private HeroiService heroiService;

  @GetMapping
  public ResponseEntity<List<Heroi>> listar() {
    var herois = heroiService.consultar(); 
    return ResponseEntity.ok().body(herois);
  }
}
