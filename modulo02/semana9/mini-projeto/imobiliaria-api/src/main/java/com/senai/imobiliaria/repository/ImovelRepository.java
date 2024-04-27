package com.senai.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.imobiliaria.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer>{
  
}
