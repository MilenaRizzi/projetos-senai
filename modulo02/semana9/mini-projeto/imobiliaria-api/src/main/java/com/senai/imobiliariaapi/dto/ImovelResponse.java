package com.senai.imobiliariaapi.dto;

import java.time.LocalDate;

import com.senai.imobiliariaapi.model.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelResponse {
  
  private Integer codigo;
  private Tipo tipo;
  private String descricao;
  private String endereco;
  private String bairro;
  private String cidade;
  private Float valor;
  private LocalDate dataCadastro;

}
