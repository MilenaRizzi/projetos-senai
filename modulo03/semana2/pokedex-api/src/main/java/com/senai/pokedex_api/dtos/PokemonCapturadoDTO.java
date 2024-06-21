package com.senai.pokedex_api.dtos;

import com.senai.pokedex_api.enums.Tipo;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PokemonCapturadoDTO {

  @NotNull
  @Min(1)
  @Max(1025)
  private int numero;

  @NotBlank
  private String nome;
  
  @NotBlank
  private String descricao;

  @NotBlank
  private String imagem;
  
  @NotBlank
  private Tipo tipo;
  
  @NotBlank
  private String categoria;

  @NotBlank
  private String area;

  @NotNull
  @Min(0)
  private Double altura;

  @NotNull
  @Min(0)
  private Double peso;
}
