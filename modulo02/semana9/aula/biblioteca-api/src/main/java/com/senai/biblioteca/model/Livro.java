package com.senai.biblioteca.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
  private String isbn;
  private String titulo;
  private String nomeAutor;
  private Integer qtdPaginas;
  private LocalDate dataPublicacao;
}
