package com.senai.imobiliaria.dto;

import java.time.LocalDate;

import com.senai.imobiliaria.model.Endereco;
import com.senai.imobiliaria.model.Tipo;

import lombok.Data;

@Data
public class ImovelResponse {
  private Integer codigo;
  private Tipo tipo;
  private String descricao;
  private Endereco endereco;
  private Float valor;
  private LocalDate dataCadastro;
}
