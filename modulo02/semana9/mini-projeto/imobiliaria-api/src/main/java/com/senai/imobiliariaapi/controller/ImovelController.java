package com.senai.imobiliariaapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.imobiliariaapi.dto.ImovelRequest;
import com.senai.imobiliariaapi.dto.ImovelResponse;
import com.senai.imobiliariaapi.mapper.ImovelMapper;
import com.senai.imobiliariaapi.model.Imovel;
import com.senai.imobiliariaapi.service.ImovelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("imoveis")
public class ImovelController {
  
  @Autowired
  private ImovelService service;

  @Autowired
  private ImovelMapper mapper;
  
  @GetMapping
  public ResponseEntity<List<ImovelResponse>> listar(){
    List<Imovel> imoveis = service.consultar();
    var resp = imoveis.stream()
                 .map(imovel -> mapper.toResponse(imovel))
                 .toList();
    return ResponseEntity.ok().body(resp);
  }  

  @GetMapping("{codigo}")
  public ResponseEntity<ImovelResponse> consultar(@PathVariable Integer codigo) {
    Imovel imovel = service.consultar(codigo);
    ImovelResponse resp = mapper.toResponse(imovel);
    return ResponseEntity.ok().body(resp);
  }

  @PostMapping
  public ResponseEntity<ImovelResponse> adicionar(@RequestBody @Valid ImovelRequest request) {
    //sem biblioteca auxiliar
    // Imovel imovel = new Imovel(request.getCodigo(), request.getTipo(), request.getDescricao(), request.getEndereco(), request.getBairro(), request.getCidade(), request.getValor(), request.getDataCadastro());
    // ImovelResponse resp = new ImovelResponse(imovel.getCodigo(), imovel.getTipo() , imovel.getDescricao(), imovel.getEndereco(), imovel.getBairro(), imovel.getCidade(), imovel.getValor(), imovel.getDataCadastro());
    Imovel imovel = mapper.toEntity(request);
    imovel = service.adicionar(imovel);
    ImovelResponse resp = mapper.toResponse(imovel);
    return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
  }

  @PutMapping("{codigo}") 
  public ResponseEntity<ImovelResponse> atualizar(@PathVariable Integer codigo, @RequestBody  @Valid ImovelRequest request) {
    Imovel imovel = mapper.toEntity(request);
    imovel = service.alterar(imovel);
    ImovelResponse resp = mapper.toResponse(imovel);
    return ResponseEntity.ok(resp);
  }

  @DeleteMapping("{codigo}")
  public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
    service.excluir(codigo);
    return ResponseEntity.noContent().build();
  }

}
