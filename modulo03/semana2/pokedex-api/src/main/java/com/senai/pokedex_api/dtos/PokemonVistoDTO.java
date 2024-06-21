package com.senai.pokedex_api.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PokemonVistoDTO {

  @NotNull
  @Min(1)
  @Max(1025)
  private int numero;

  @NotBlank
  private String nome;
  
  @NotBlank
  private String imagem;
  
  @NotBlank
  private String area;

}
