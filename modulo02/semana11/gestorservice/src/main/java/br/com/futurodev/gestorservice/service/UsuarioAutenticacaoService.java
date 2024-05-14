package br.com.futurodev.gestorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.futurodev.gestorservice.model.UsuarioEntity;

@Service
public class UsuarioAutenticacaoService {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    public String autenticacaoUsuario(String email, String senha) {
        UsernamePasswordAuthenticationToken usuarioAutenticacao = new UsernamePasswordAuthenticationToken(email, senha);
        Authentication autenticacao = this.authenticationManager.authenticate(usuarioAutenticacao);
    
        UsuarioEntity usuario = (UsuarioEntity) autenticacao.getPrincipal();
        return this.jwtTokenService.gerarToken(usuario);
    }
}
