package com.senai.imobiliaria.dto;

import com.senai.imobiliaria.model.Endereco;
import com.senai.imobiliaria.model.Tipo;

import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ImovelRequest {

  @NotNull(message = "Campo obrigatório")
  @Positive(message = "Valor inválido")
  private Integer codigo;

  @NotNull(message = "Campo obrigatório")
  private Tipo tipo;

  @NotEmpty(message = "Campo obrigatório")
  @Size(min = 3, max = 200)
  private String descricao;

  @Embedded
  @Valid
  @NotNull(message = "Campo obrigatório")
  private Endereco endereco;

  @NotNull(message = "Campo obrigatório")
  @Positive(message = "Valor inválido")
  private Float valor;

}
