package com.senai.personagens.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.personagens.exceptions.RegistroNaoExistenteException;
import com.senai.personagens.model.Personagem;
import com.senai.personagens.repository.PersonagemRepository;

@Service
public class PersonagemService {

  @Autowired
  private PersonagemRepository personagemRepository;

  public List<Personagem> consultar() {
    return personagemRepository.findAll();
  }

  public Personagem consultar(Integer id) {
    Optional<Personagem> personagemOpt = personagemRepository.findById(id);
    if (personagemOpt.isEmpty()) {
      throw new RegistroNaoExistenteException();
    }
    return personagemOpt.get();

    // return repository.findById(id).orElseThrow(()-> new RegistroNaoExistenteException());
  }
  
  public Personagem consultarPorNome(String nome) {
    Optional<Personagem> personagemOpt = personagemRepository.findByNome(nome);
    if (personagemOpt.isEmpty())
        throw new IllegalArgumentException("Personagem nao encontrado com o nome " + nome);
    return personagemOpt.get();
}

  public Personagem consultarPor(String nome, String referencia) {
    Optional<Personagem> personagemOpt = personagemRepository.obterPorNomeEreferenciaComJPQL(nome, referencia);
    return personagemOpt.orElseThrow(() -> new IllegalArgumentException("Registro nao encontrado"));
}


  public Personagem inserir(Personagem personagem) {
    //regra de negócio: Não deve haver mais de um personagem com o mesmo nome
    //nesse uso do optional aqui o sistema busca todo objeto de personagem só para conferir se um determindo nome já existe. Se charmamos apenas o metodo existeByNome teremos um retorno booelan, e o objeto inteiro não é retornado. Isso é melhor para performance. 
    // Optional<Personagem> personagemOpt = personagemRepository.findByNome(personagem.getNome());
    boolean existeComNome = personagemRepository.existsByNome(personagem.getNome());
    if (existeComNome) {
      throw new IllegalArgumentException("Nome já registrado");
    }

    personagem.setDataCadastro(LocalDate.now());
    return personagemRepository.save(personagem);
  }

  public void atualizar(Personagem dados) {
    var personagem = this.consultar(dados.getId());
    personagem.setNome(dados.getNome());
    personagem.setTipo(dados.getTipo());
    personagem.setReferencia(dados.getReferencia());
    personagem.setDataCadastro(dados.getDataCadastro());
    personagemRepository.save(personagem);
  }

  public void excluir(Integer id) {
    boolean existe = personagemRepository.existsById(id);
    if (!existe) {
      throw new RegistroNaoExistenteException();
    }
    personagemRepository.deleteById(id);
  }

}
