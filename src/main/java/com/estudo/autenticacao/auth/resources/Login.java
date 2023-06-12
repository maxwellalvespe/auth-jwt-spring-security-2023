package com.estudo.autenticacao.auth.resources;

import com.estudo.autenticacao.auth.resources.dto.FormLogin;
import com.estudo.autenticacao.auth.services.ServiceLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class Login {

    private final ServiceLogin serviceLogin;

    public Login(ServiceLogin login){
        this.serviceLogin = login;
    }
    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody FormLogin login) {
        return new ResponseEntity(serviceLogin.getToken(login), HttpStatus.CREATED);
    }
}
