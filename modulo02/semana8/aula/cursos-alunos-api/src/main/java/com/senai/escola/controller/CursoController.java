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
import com.senai.escola.model.Curso;
import com.senai.escola.service.AlunoService;
import com.senai.escola.service.CursoService;

@RestController
@RequestMapping("cursos")
public class CursoController {
  
  @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        var cursos = cursoService.consultar();
        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Curso> consultarPeloCodigo(@PathVariable Integer codigo) {
        var curso = cursoService.consultar(codigo);
        return ResponseEntity.ok().body(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        cursoService.inserir(curso);
        return ResponseEntity.created(URI.create(curso.getCodigo().toString())).body(curso);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Curso> atualizar(@PathVariable Integer codigo, @RequestBody Curso curso) {
        curso.setCodigo(codigo);
        cursoService.atualizar(curso);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<Curso> excluir(@PathVariable Integer codigo) {
        cursoService.excluirPorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{codigo}/alunos/{cpf}")
    public ResponseEntity<Aluno> matricular(@PathVariable Integer codigo, @PathVariable Long cpf) {
        var curso = cursoService.consultar(codigo);
        var aluno = alunoService.consultar(cpf);
        alunoService.matricular(curso, aluno);
        return ResponseEntity.ok().body(aluno);
    }
}   
