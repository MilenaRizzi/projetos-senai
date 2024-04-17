package com.senai.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.escola.exception.RegistroNaoExistenteException;
import com.senai.escola.model.Curso;
import com.senai.escola.repository.CursoRepository;

@Service
public class CursoService {
  @Autowired
  private CursoRepository cursoRepo;

  public List<Curso> consultar() {
      return cursoRepo.findAll();
  }

  public Curso consultar(Integer codigo) {
    var cursoOpt = cursoRepo.findById(codigo);
    if (cursoOpt.isEmpty())
        throw new RegistroNaoExistenteException();
    return cursoOpt.get(); 
}

public void inserir(Curso curso) {
    cursoRepo.save(curso);
}

public void atualizar(Curso dados) {
    var curso = this.consultar(dados.getCodigo());
    curso.setCategoria(dados.getCategoria());
    curso.setDescricao(dados.getDescricao());
    curso.setPreco(dados.getPreco());
    curso.setDataInicio(dados.getDataInicio());
    curso.setDataFim(dados.getDataFim());
    cursoRepo.save(curso);
}


  public void excluirPorCodigo(Integer codigo) {
      var curso = this.consultar(codigo);
      cursoRepo.delete(curso);
  }
  
}
