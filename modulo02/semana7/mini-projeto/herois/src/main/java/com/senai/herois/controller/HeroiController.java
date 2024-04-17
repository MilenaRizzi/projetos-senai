package com.senai.herois.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.herois.dto.HeroiInclusaoRequest;
import com.senai.herois.dto.HeroiResponse;
import com.senai.herois.model.Heroi;
import com.senai.herois.service.HeroiService;

@RestController
@RequestMapping
public class HeroiController {
  
  @Autowired
  private HeroiService heroiService;


  @PostMapping
  public ResponseEntity<HeroiResponse> inserir (@RequestBody HeroiInclusaoRequest request) {
    var heroi = new Heroi(request.getNome(), request.getSuperpoder(), request.getIdade(), request.getCidade());

    heroi = heroiService.inserir(heroi);
    var resp = new HeroiResponse(heroi);
    return ResponseEntity.created(URI.create(heroi.getNome().toString())).body(resp);
  }

  @GetMapping
  public ResponseEntity<List<HeroiResponse>> listar() {
    var herois = heroiService.consultar(); 
    var resp = new ArrayList<HeroiResponse>();
    for (var heroi : herois) {
      resp.add(new HeroiResponse(heroi));
    }
    return ResponseEntity.ok().body(resp);
  }
}
