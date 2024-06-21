package com.senai.pokedex_api.model;

import com.senai.pokedex_api.enums.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon {

  @Id
  private Integer numero;

  @Column(nullable = false, unique = true)
  private String nome;

  private String descricao;

  @Column(nullable = false)
  private String imagem;

  @Enumerated(value = EnumType.STRING)
  private Tipo tipo;

  private String categoria;

  @Column(nullable = false)
  private String area;

  private Double altura;

  private Double peso;

  @Column(nullable = false)
  private boolean capturado;

}
