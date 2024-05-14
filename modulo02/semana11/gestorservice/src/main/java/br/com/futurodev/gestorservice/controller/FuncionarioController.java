package br.com.futurodev.gestorservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futurodev.gestorservice.model.FuncionarioEntity;
import br.com.futurodev.gestorservice.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioEntity> inserir(@RequestBody FuncionarioEntity funcionarioEntity) {
        var funcionarioInserido = this.funcionarioService.inserir(funcionarioEntity);
        return ResponseEntity.created(URI.create("/api/funcionarios/" + funcionarioInserido.getIdUsuario()))
            .body(funcionarioInserido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> buscarFuncionario(@PathVariable Integer id) {
        return ResponseEntity.ok(this.funcionarioService.buscarPorId(id));
    }
}
