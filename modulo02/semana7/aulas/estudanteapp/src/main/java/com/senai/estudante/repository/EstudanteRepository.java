package com.senai.estudante.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.senai.estudante.model.Estudante;

@Repository
public class EstudanteRepository {

    private List<Estudante> lista = List.of(
        new Estudante("ABC111", "Milena", "milena@senai.com.br"), 
        new Estudante("ABC222", "Rodrigo", "rodrigo@senai.com.br"), 
        new Estudante("ABC333", "Lucas", "lucas@senai.com.br")
    );
    

    public List<Estudante> consultar() {
        return lista;
    }

    public void inserir(Estudante estudante) {
        var nova = new ArrayList<>(lista);
        nova.add(estudante);
        lista = nova;
    }

    public Optional<Estudante> consultar(String matricula) {
        Optional<Estudante> estudanteOpt = Optional.empty();
        for (var e : lista) {
            if (e.getMatricula().equals(matricula))
                estudanteOpt = Optional.of(e);
                break;
        }
        return estudanteOpt;
    }

    public boolean existe(String matricula) {
        for (var e : lista) {
           if (e.getMatricula().equals(matricula))
            return true;
        }
        return false;
    }

}