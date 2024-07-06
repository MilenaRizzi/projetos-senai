package com.senai.pokedex_api.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonAtualizadoDTO {
    @NotNull
    @Min(1)
    @Max(1025)
    private Integer numero;
  
    @NotBlank private String nome;
    private String descricao;
    @NotBlank private String imagem;
    private String tipo;
    private String categoria;
    @NotBlank private String area;
    private Double altura;
    private Double peso;
    @NotNull private Boolean capturado;
}
