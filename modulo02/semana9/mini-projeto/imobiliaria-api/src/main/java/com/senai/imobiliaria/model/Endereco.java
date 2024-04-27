package com.senai.imobiliaria.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Valid
public class Endereco {

  @NotEmpty(message = "Rua é obrigatoria")
  @Size(min = 3, max = 50, message = "O nome da rua deve ter entre 3 e 50 caracteres")
  private String rua;

  @NotNull(message = "Número é obrigatorio")
  private int numero;

  @NotEmpty(message = "Bairro é obrigatorio")
  @Size(min = 3, max = 50, message = "O nome do bairro deve ter entre 3 e 50 caracteres")
  private String bairro;

  @NotEmpty(message = "Cidade é obrigatoria")
  @Size(min = 2, max = 30, message = "O nome da cidade deve ter entre 2 e 30 caracteres")
  private String cidade;

  @NotEmpty(message = "Estado é obrigatorio")
  @Size(min = 2, max = 30, message = "O nome do estado deve ter entre 2 e 30 caracteres")
  private String estado;
}

//obs: Endereco é uma classe @Embeddable, então a anotação @Column não é necessária ou relevante para a configuração das colunas do banco de dados. A anotação @Column é utilizada quando você está mapeando uma entidade para uma tabela no banco de dados usando JPA (@Entity).