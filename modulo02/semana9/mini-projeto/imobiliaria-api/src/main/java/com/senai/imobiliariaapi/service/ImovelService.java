package com.senai.imobiliariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.imobiliariaapi.expcetion.RegistroExistenteException;
import com.senai.imobiliariaapi.expcetion.RegistroNaoEncontradoException;
import com.senai.imobiliariaapi.model.Imovel;
import com.senai.imobiliariaapi.repository.ImovelRepository;

@Service
public class ImovelService {
  
  @Autowired
  private ImovelRepository repository;

  public Imovel adicionar(Imovel imovel) {
    boolean existe = repository.existsById(imovel.getCodigo());
    if (existe) {
      throw new RegistroExistenteException();
    }
    return repository.save(imovel);
  }

  public List<Imovel> consultar() {
    return repository.findAll();
  }

  public Imovel consultar(Integer codigo) {
    return repository.findById(codigo)
    .orElseThrow(() -> new RegistroNaoEncontradoException());
  }

  public void excluir(Integer codigo) {
    var imovel = repository.findById(codigo).orElseThrow(() -> new RegistroNaoEncontradoException());
    repository.delete(imovel);
  }

  public Imovel alterar(Imovel imovelAtualizado) {
    var imovel = repository.findById(imovelAtualizado.getCodigo()).orElseThrow(() -> new RegistroNaoEncontradoException());
    imovel.setTipo(imovelAtualizado.getTipo());
    imovel.setDescricao(imovelAtualizado.getDescricao());
    imovel.setEndereco(imovelAtualizado.getEndereco());
    imovel.setBairro(imovelAtualizado.getBairro());
    imovel.setCidade(imovelAtualizado.getCidade());
    imovel.setValor(imovelAtualizado.getValor());
    imovel.setDataCadastro(imovelAtualizado.getDataCadastro());
    return imovel;
  }
  

}
