package com.senai.imobiliaria.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.imobiliaria.dto.ImovelAtualizacaoRequest;
import com.senai.imobiliaria.dto.ImovelRequest;
import com.senai.imobiliaria.dto.ImovelResponse;
import com.senai.imobiliaria.model.Imovel;
import com.senai.imobiliaria.service.ImovelService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("imoveis")
public class ImovelController {

  @Autowired
  private ImovelService service;

  @Autowired
  private ModelMapper mapper;

  @PreAuthorize("hasRole('PARKING_INSERT')")
  @PostMapping
  public ResponseEntity<ImovelResponse> cadastrar(@RequestBody @Valid ImovelRequest request) {
    Imovel imovel = mapper.map(request, Imovel.class);
    service.cadastrar(imovel);
    var resp = mapper.map(imovel, ImovelResponse.class);
    return ResponseEntity.created(URI.create(imovel.getCodigo().toString())).body(resp);
  }

  @PreAuthorize("hasRole('PARKING_SELECT')")
  @GetMapping
  public ResponseEntity<List<ImovelResponse>> listar() {
    var imoveis = service.consultar();
    var resp = imoveis.stream().map(imovel -> mapper.map(imovel, ImovelResponse.class)).toList();
    return ResponseEntity.ok().body(resp);
  }

  @PreAuthorize("hasRole('PARKING_SELECT')")
  @GetMapping("{codigo}")
  public ResponseEntity<ImovelResponse> consultarPorCodigo(@PathVariable Integer codigo) {
    var imovel = service.consultar(codigo);
    var resp = mapper.map(imovel, ImovelResponse.class);
    return ResponseEntity.ok().body(resp);
  }

  @PreAuthorize("hasRole('PARKING_UPDATE')")
  @PutMapping("{codigo}")
  public ResponseEntity<ImovelResponse> atualizar(@PathVariable Integer codigo,
      @RequestBody @Valid ImovelAtualizacaoRequest request) {
    var imovel = mapper.map(request, Imovel.class);
    imovel.setCodigo(codigo);
    imovel = service.atualizar(imovel);
    var resp = mapper.map(imovel, ImovelResponse.class);
    return ResponseEntity.ok().body(resp);
  }

  @PreAuthorize("hasRole('PARKING_DELETE')")
  @DeleteMapping("{codigo}")
  public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
    service.excluir(codigo);
    return ResponseEntity.noContent().build();
  }
}
