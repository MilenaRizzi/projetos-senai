package com.senai.escola.model;

import java.time.LocalDate;

import com.senai.escola.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // Entidade JPA
@Table(name = "Cursos") // Nome da Tabela 
public class Curso {

  @Id
  private Integer codigo;
  private Float preco;

  // para usar o nome da string como enum no banco, e não o ordinal (0,1,2) que é o padrão 
  @Enumerated(EnumType.STRING) 
  private Categoria categoria;
  private String descricao;
  private LocalDate dataInicio;
  private LocalDate dataFim;
  
}
