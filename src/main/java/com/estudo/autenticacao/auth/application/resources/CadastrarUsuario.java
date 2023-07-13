package com.estudo.autenticacao.auth.application.resources;

import com.estudo.autenticacao.auth.application.dto.FormLogin;
import com.estudo.autenticacao.auth.domain.services.CadastrarUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/cadastro")
@RequiredArgsConstructor
@Slf4j
public class CadastrarUsuario {

    private final CadastrarUsuarioService cadastroUsuario;
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody FormLogin request) throws IllegalAccessException, InterruptedException {
        log.info("INICIANDO THREAD");
        Thread.sleep(3000);
        log.info("FINALIZANDO THREAD");
       return new ResponseEntity<>(cadastroUsuario.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return cadastroUsuario.findAll();
    }
}
