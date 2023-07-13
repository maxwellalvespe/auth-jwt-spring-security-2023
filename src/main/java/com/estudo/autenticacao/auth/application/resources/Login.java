package com.estudo.autenticacao.auth.application.resources;

import com.estudo.autenticacao.auth.application.dto.FormLogin;
import com.estudo.autenticacao.auth.domain.services.ServiceLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/token")
@Slf4j
public class Login {

    private final ServiceLogin serviceLogin;

    public Login(ServiceLogin login) {
        this.serviceLogin = login;
    }

    @PostMapping
    public ResponseEntity<?> getToken(@RequestBody FormLogin login) {
        return new ResponseEntity(serviceLogin.getToken(login), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> health() {
        log.info("GET HEALTH::");
        var response = new HashMap<String, String>();
        response.put("message", "Connection success!");
        return ResponseEntity.ok(response);
    }
}
