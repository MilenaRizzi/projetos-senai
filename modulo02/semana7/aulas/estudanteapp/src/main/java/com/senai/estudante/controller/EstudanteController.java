package com.senai.estudante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.estudante.model.Estudante;
import com.senai.estudante.service.EstudanteService;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;
    
    @GetMapping
    public ResponseEntity<List<Estudante>> listar() {
        var estudantes = service.consultar();
        return ResponseEntity.ok(estudantes);
    }

    @PostMapping
    public ResponseEntity<Estudante> inserir(@RequestBody Estudante estudante) {
        if (estudante.getMatricula() == null) {
            System.out.println("Matricula nao informada!");
            return ResponseEntity.badRequest().build();
        }
        try {
            service.inserir(estudante);
        } catch (IllegalArgumentException e) {
            System.out.println("Matricula repetida");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(estudante);
    }

}