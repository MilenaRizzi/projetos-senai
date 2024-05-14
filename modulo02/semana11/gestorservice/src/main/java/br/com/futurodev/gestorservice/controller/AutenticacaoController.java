package br.com.futurodev.gestorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futurodev.gestorservice.dtos.LoginRequestDTO;
import br.com.futurodev.gestorservice.dtos.LoginRespostaDTO;
import br.com.futurodev.gestorservice.service.UsuarioAutenticacaoService;

@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    private static final Logger logger = LoggerFactory.getLogger(AutenticacaoController.class);

    @Autowired
    private UsuarioAutenticacaoService usuarioAutenticacaoService;

    @PostMapping("/login")
    public ResponseEntity<LoginRespostaDTO> login(@RequestBody LoginRequestDTO login) {
        logger.trace("Usuario entrou no login");
        logger.info("Usuario {} comecou a autenticacao", login.getEmail());
        String token = this.usuarioAutenticacaoService.autenticacaoUsuario(login.getEmail(), login.getSenha());
        logger.info("Usuario {} terminou de realizar autenticacao", login.getEmail());
        logger.trace("Usuario criou token");
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginRespostaDTO(token));
    }

}
