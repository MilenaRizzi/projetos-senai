package com.senai.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.escola.exception.RegistroNaoExistenteException;
import com.senai.escola.model.Aluno;
import com.senai.escola.model.Curso;
import com.senai.escola.repository.AlunoRepository;

@Service
public class AlunoService {
  @Autowired
  private AlunoRepository alunoRepository;

  public List<Aluno> consultar() {
    return alunoRepository.findAll();
  }

  public Aluno consultar(Long cpf) {
    var alunoOpt = alunoRepository.findById(cpf);
    if (alunoOpt.isEmpty()) {
      throw new RegistroNaoExistenteException();
    }
    return alunoOpt.get();
  }

  public void inserir(Aluno aluno) {
    alunoRepository.save(aluno);
  }


  public void atualizar(Aluno dados) {
    var aluno = this.consultar(dados.getCpf());
    aluno.setDataNascimento(dados.getDataNascimento());
    aluno.setNome(dados.getNome());
    alunoRepository.save(aluno);
  }

  public void excluirPorCodigo(Long cpf) {
    var aluno = this.consultar(cpf);
    alunoRepository.delete(aluno);
  }

  
  public void matricular(Curso curso, Aluno aluno) {
    aluno.setCurso(curso);
    alunoRepository.save(aluno);
}
}
