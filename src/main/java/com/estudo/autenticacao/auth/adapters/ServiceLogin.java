package com.estudo.autenticacao.auth.adapters;

import com.estudo.autenticacao.auth.resources.dto.FormLogin;
import com.estudo.autenticacao.auth.resources.dto.ResponseLogin;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceLogin {
    public ResponseLogin getToken(FormLogin login) {


        return new ResponseLogin("dGVzdGU=", LocalDateTime.now().plusDays(1).toString());
    }
}
