package com.senai.personagens.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.personagens.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

  Optional<Personagem> findByNome(String nome);

  boolean existsByNome(String nome);

  // para esse metodo obterPorNomeEreferencia, usar minha native query(sql puro),
  // respeitando o comando sql que eu determinei em value
  // com isso ao reconher esse método o spring não vai tentar criar ele mesmo o
  // sql, mas sim vai usar o sql que eu determinei
  //query nativa - sql - mundo relacional - aqui trabalhamos com a tabela personagens do banco
  @Query(value = "SELECT * FROM personagens WHERE nome = :nome AND referencia = :referencia", nativeQuery = true)
  Optional<Personagem> obterPorNomeEreferencia(String nome, String referencia);

  // usando JPQL - quando construo sql usando uma notação mais orientada a objetos
  // não é uma query nativa
  /* o que muda é que agora ao invés de colocar o nome da tabela (que na query acima é personagens), 
  vou colocar a classe, que nesse caso é Personagem, que será representada por p, e do Personagem p,
  eu quero voltar o p.nome e esse nome será o atributo nome da classe Personagem e o p.referencia 
  - se eu quisesse voltar so o nome do personagem eu colocaria Select p.nome FROM, quando coloco 
  apenas p é pq queremos retornar todos os dados */
  @Query(value = "SELECT p FROM Personagem p WHERE p.nome = :nome AND p.referencia = :referencia")
  Optional<Personagem> obterPorNomeEreferenciaComJPQL(String nome, String referencia);
}
