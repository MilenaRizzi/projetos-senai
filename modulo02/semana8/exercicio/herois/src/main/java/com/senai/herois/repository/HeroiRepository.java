package com.senai.herois.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.herois.model.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, String> {


}
