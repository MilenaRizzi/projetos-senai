package com.senai.imobiliariaapi.dto;

import java.time.LocalDate;

import com.senai.imobiliariaapi.model.Tipo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelRequest {
  @NotNull(message = "Campo obrigatório")
  private Integer codigo;

  private Tipo tipo;
  
  @NotEmpty(message = "Campo obrigatório") 
  @Size(min=1, max = 100, message = "Tamanho inválido") 
  private String descricao;

  @NotEmpty(message = "Campo obrigatório") 
  @Size(min=1, max = 100, message = "Tamanho inválido") 
  private String endereco;

  @NotEmpty(message = "Campo obrigatório") 
  @Size(min=1, max = 100, message = "Tamanho inválido") 
  private String bairro;

  @NotEmpty(message = "Campo obrigatório") 
  @Size(min=1, max = 100, message = "Tamanho inválido") 
  private String cidade;

  @NotNull(message = "Campo obrigatório") 
  private Float valor;

  @NotNull(message = "Campo obrigatório") 
  private LocalDate dataCadastro;
}
