package com.estudo.autenticacao.auth.adapters;

import com.estudo.autenticacao.auth.model.Usuario;
import com.estudo.autenticacao.auth.resources.dto.FormLogin;
import com.estudo.autenticacao.auth.resources.dto.ResponseLogin;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceLogin {

    private final AuthenticationManager authenticationManager;

    public ServiceLogin(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ResponseLogin getToken(FormLogin login) {
        var userNamePaswdToken = new UsernamePasswordAuthenticationToken(login.user(), login.password());

        var autenticated = this.authenticationManager.authenticate(userNamePaswdToken);

        var usuario = (Usuario) autenticated.getPrincipal();

        return new ResponseLogin("dGVzdGU=", LocalDateTime.now().plusDays(1).toString());
    }
}
