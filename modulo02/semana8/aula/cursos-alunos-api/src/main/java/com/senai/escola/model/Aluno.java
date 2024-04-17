package com.senai.escola.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Alunos")
public class Aluno {

  @Id
  private Long cpf;
  private String nome;
  private LocalDate dataNascimento;

  @ManyToOne
  @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo") //a coluna codigo_curso será referenciada pela coluna código lá da tabela de curso -> porque curso tem a coluna codigo, então a coluna de aluno chamada de codigo_curso fará referencia a coluna codigo (que é o id de curso) que estará lá na classe curso. 
  private Curso curso;

}
