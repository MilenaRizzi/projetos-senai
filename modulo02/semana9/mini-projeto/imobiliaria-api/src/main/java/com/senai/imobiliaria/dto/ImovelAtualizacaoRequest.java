package com.senai.imobiliaria.dto;

import com.senai.imobiliaria.model.Endereco;
import com.senai.imobiliaria.model.Tipo;

import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ImovelAtualizacaoRequest {

  @NotNull(message = "Campo obrigatório")
  private Tipo tipo;

  @NotEmpty(message = "Campo obrigatório")
  private String descricao;

  @Embedded
  @NotNull(message = "Campo obrigatório")
  @Valid //para validar os atributos que estão na classe endereço eu preciso colocar o valid
  private Endereco endereco;

  @NotNull(message = "Campo obrigatório")
  @Positive(message = "Valor inválido")
  private Float valor;
}
