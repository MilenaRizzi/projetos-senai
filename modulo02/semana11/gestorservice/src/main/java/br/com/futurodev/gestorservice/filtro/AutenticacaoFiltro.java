package br.com.futurodev.gestorservice.filtro;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.futurodev.gestorservice.config.SegurancaConfig;
import br.com.futurodev.gestorservice.exceptions.AcessoNegadoException;
import br.com.futurodev.gestorservice.service.JwtTokenService;
import br.com.futurodev.gestorservice.service.UsuarioDetalhesService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AutenticacaoFiltro extends OncePerRequestFilter{

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioDetalhesService usuarioDetalhesService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (isEndpointPrivado(request)) {
            String token = recuperaTokenDaRequest(request);
            if (token == null) {
                throw new AcessoNegadoException("Token nao informado");
            }
            String usuarioEmail = this.jwtTokenService.getUsuarioApartirToken(token);
            UserDetails usuarioDetalhe = this.usuarioDetalhesService.loadUserByUsername(usuarioEmail);
    
            Authentication autenticacao = new UsernamePasswordAuthenticationToken(usuarioDetalhe.getUsername(), 
             null, usuarioDetalhe.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        } 
        filterChain.doFilter(request, response);
    }

    private boolean isEndpointPrivado(HttpServletRequest request) {
        return !Arrays.asList(SegurancaConfig.ENDPOINTS_SEM_AUTENTICACAO).contains(request.getRequestURI());
    }

    private String recuperaTokenDaRequest(HttpServletRequest request) {
        String cabecalhoAutorizacao = request.getHeader("Authorization");
        if (cabecalhoAutorizacao != null) {
            return cabecalhoAutorizacao.replace("Bearer ", "");
        }
        return null;
    }

}
