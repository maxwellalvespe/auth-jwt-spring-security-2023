package com.estudo.autenticacao.auth.resources;

import com.estudo.autenticacao.auth.adapters.ServiceLogin;
import com.estudo.autenticacao.auth.resources.dto.FormLogin;
import com.estudo.autenticacao.auth.resources.dto.ResponseLogin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Login {

    private final ServiceLogin serviceLogin;

    public Login(ServiceLogin login){
        this.serviceLogin = login;
    }
    @PostMapping("/token")
    public ResponseEntity<ResponseLogin> getToken(@RequestBody FormLogin login) {
        return new ResponseEntity(serviceLogin.getToken(login), HttpStatus.CREATED);
    }
}
