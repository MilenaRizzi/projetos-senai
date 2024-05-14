package br.com.futurodev.gestorservice.service;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.futurodev.gestorservice.exceptions.AcessoNegadoException;
import br.com.futurodev.gestorservice.model.UsuarioEntity;

@Service
public class JwtTokenService {

    private static final String CHAVE_SECRETA = "algumacoisa";
    private static final String EMISSOR = "gestor-service";

    public String gerarToken(UsuarioEntity usuario) {
        Algorithm algoritmoHmac256 = Algorithm.HMAC256(CHAVE_SECRETA);
        return JWT.create()
            .withIssuer(EMISSOR)
            .withIssuedAt(ZonedDateTime.now().toInstant())
            .withExpiresAt(ZonedDateTime.now().plusMinutes(10).toInstant())
            .withSubject(usuario.getEmail())
            .withClaim("papel", usuario.getPapel().name())
            .withClaim("nome", usuario.getNome())
            .sign(algoritmoHmac256);
    }

    public String getUsuarioApartirToken(String token) {
        try {
            Algorithm algoritmoHmac256 = Algorithm.HMAC256(CHAVE_SECRETA);
            return JWT.require(algoritmoHmac256)
                .withIssuer(EMISSOR)
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            throw new AcessoNegadoException("Token invalido ou expirado.");
        }
    }

}
