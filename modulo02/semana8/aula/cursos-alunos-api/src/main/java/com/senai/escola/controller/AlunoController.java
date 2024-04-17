package com.senai.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.escola.model.Aluno;
import com.senai.escola.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoController {
  
  @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        var aluno = alunoService.consultar();
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<Aluno> consultarPeloCodigo(@PathVariable Long cpf) {
        var aluno = alunoService.consultar(cpf);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        alunoService.inserir(aluno);
        return ResponseEntity.created(URI.create(aluno.getCpf().toString())).body(aluno);
    }

    @PutMapping("{cpf}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long cpf, @RequestBody Aluno aluno) {
        aluno.setCpf(cpf);
        alunoService.atualizar(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity<Aluno> excluir(@PathVariable Long cpf) {
        alunoService.excluirPorCodigo(cpf);
        return ResponseEntity.noContent().build();
    }

    // @PutMapping("{codigo}/alunos/{cpf}")
    // public ResponseEntity<Aluno> matricular(@PathVariable Integer codigo, @PathVariable Long cpf) {
    //     var curso = alunoService.consultar(codigo);
    //     var aluno = alunoService.consultar(cpf);
    //     alunoService.matricular(curso, aluno);
    //     return ResponseEntity.ok().body(aluno);
    // }
}
