package com.senai.imobiliariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.imobiliariaapi.model.Imovel;

@Repository
public interface ImovelRepository  extends JpaRepository<Imovel, Integer>{
   
}
