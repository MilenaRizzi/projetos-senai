package br.com.futurodev.gestorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.futurodev.gestorservice.exceptions.AcessoNegadoException;
import br.com.futurodev.gestorservice.repository.UsuarioRepository;

@Service
public class UsuarioDetalhesService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.usuarioRepository.findByEmail(username)
            .orElseThrow(() -> new AcessoNegadoException("Usuario nao encontrado"));
    }

}
