package com.senai.imobiliariaapi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imoveis")
public class Imovel {
  
  @Id
  private Integer codigo;
  private Tipo tipo;
  private String descricao;
  private String endereco;
  private String bairro;
  private String cidade;
  private Float valor;
  private LocalDate dataCadastro;

}
