package com.senai.imobiliaria.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.imobiliaria.exception.RegistroExistenteException;
import com.senai.imobiliaria.exception.RegistroNaoEncontradoException;
import com.senai.imobiliaria.model.Imovel;
import com.senai.imobiliaria.repository.ImovelRepository;

@Service
public class ImovelService {

  @Autowired
  private ImovelRepository repository;

  public void cadastrar(Imovel imovel) {
    boolean existe = repository.existsById(imovel.getCodigo());
    if (existe) {
      throw new RegistroExistenteException("Imovel com código já cadastrado");
    }
    imovel.setDataCadastro(LocalDate.now());
    repository.save(imovel);
  }

  public List<Imovel> consultar() {
    return repository.findAll();
  }

  public Imovel consultar(Integer codigo) {
    return repository.findById(codigo)
        .orElseThrow(() -> new RegistroNaoEncontradoException("Imovel não encontrado com código informado"));
  }

  public Imovel atualizar(Imovel dadosAtualizados) {
    var imovelBD = this.consultar(dadosAtualizados.getCodigo());
    imovelBD.setDescricao(dadosAtualizados.getDescricao());
    imovelBD.setTipo(dadosAtualizados.getTipo());
    imovelBD.setEndereco(dadosAtualizados.getEndereco());
    imovelBD.setValor(dadosAtualizados.getValor());
    var atualizado = repository.save(imovelBD);
    return atualizado;
  }

  public void excluir(Integer codigo) {
    boolean existe = repository.existsById(codigo);
    if (!existe)
      throw new RegistroNaoEncontradoException("Imovel nao encontrado com código informado para exclusao");
    repository.deleteById(codigo);
  }
}
