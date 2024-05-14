package br.com.futurodev.gestorservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "idUsuario")
public class ClienteEntity extends UsuarioEntity{

    @Column(name = "qtd_compras", nullable = true)
    private Integer quantidadeCompras;

}
