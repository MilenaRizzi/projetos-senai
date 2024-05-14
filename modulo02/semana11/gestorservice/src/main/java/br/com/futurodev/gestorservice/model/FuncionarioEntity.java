package br.com.futurodev.gestorservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "idUsuario")
public class FuncionarioEntity extends UsuarioEntity{

    @Column(name = "dt_contratacao", nullable = true)
    @Temporal(TemporalType.DATE)
    private LocalDate dataContratacao;
}
