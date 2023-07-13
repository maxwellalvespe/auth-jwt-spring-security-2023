package com.estudo.autenticacao.auth.domain.services;

import com.estudo.autenticacao.auth.domain.model.Usuario;
import com.estudo.autenticacao.auth.application.dto.FormLogin;
import com.estudo.autenticacao.auth.application.dto.ResponseLogin;
import com.estudo.autenticacao.auth.domain.services.auth.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceLogin {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private TokenService tokenService;

    public ResponseLogin getToken(FormLogin login) {

        UsernamePasswordAuthenticationToken userNamePaswdToken = new UsernamePasswordAuthenticationToken(login.user(), login.password());

        Authentication autenticated = authenticationManager.authenticate(userNamePaswdToken);

        var usuario = (Usuario) autenticated.getPrincipal();

        return tokenService.generetedToken(usuario);
    }
}
