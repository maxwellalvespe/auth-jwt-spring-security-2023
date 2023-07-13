package com.estudo.autenticacao.auth.domain.services.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.estudo.autenticacao.auth.application.dto.ResponseLogin;
import com.estudo.autenticacao.auth.domain.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
@Slf4j
public class TokenService {



    @Value("${secret.key}")
    private String SECRET_KEY;

    public ResponseLogin generetedToken(Usuario usuario) {
        var token = JWT.create()
                .withIssuer("GENERATED_TOKEN_JWT")
                .withSubject(usuario.getNome())
                .withClaim("id", usuario.getId().toString())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
                .sign(getAlgotihmSecretKey(SECRET_KEY))
                .toString();
        return new ResponseLogin(token,LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")).toString());
    }

    private Algorithm getAlgotihmSecretKey(String secretKey) {
        return Algorithm.HMAC256(secretKey);
    }
}
