package com.senai.imobiliaria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    
    private Tipo tipo; 
    
    @Column(length = 200, nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    @Embedded
    @Valid
    private Endereco endereco;
    
    @Column(nullable = false)
    private Float valor;
    
    @Column(nullable = false)
    private LocalDate dataCadastro; // data de cadastro será determinada pelo sistema
}
