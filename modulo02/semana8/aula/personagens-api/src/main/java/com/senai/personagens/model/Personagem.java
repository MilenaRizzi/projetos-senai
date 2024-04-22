package com.senai.personagens.model;

import java.time.LocalDate;
import com.senai.personagens.enums.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Personagens")
public class Personagem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100, nullable = false)
  private String nome;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Tipo tipo;

  @Column(length = 40, nullable = false)
  private String referencia;

  @Column(nullable = false)
  private LocalDate dataCadastro;

}
