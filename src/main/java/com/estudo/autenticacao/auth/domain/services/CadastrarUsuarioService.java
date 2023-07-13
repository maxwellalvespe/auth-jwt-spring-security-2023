package com.estudo.autenticacao.auth.domain.services;

import com.estudo.autenticacao.auth.domain.model.Usuario;
import com.estudo.autenticacao.auth.domain.repository.UsuarioRepository;
import com.estudo.autenticacao.auth.application.dto.FormLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CadastrarUsuarioService {

    private UsuarioRepository usuarioRepository;
    public CadastrarUsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario save(FormLogin request) throws IllegalAccessException {


     try{
        var retorno =  usuarioRepository.save(Usuario.builder()
                 .nome(request.user())
                 .senha(getPasswordEncode(request)).build());
        return retorno != null ? retorno : null;
     }catch (Exception e){
         throw new IllegalAccessException("Não foi possivel salvar os dados ");
     }


    }

    private static String getPasswordEncode(FormLogin request) {
        return new BCryptPasswordEncoder().encode(request.password());
    }

    public ResponseEntity<?> findAll() {
        usuarioRepository.save(Usuario.builder().nome("JOSE").senha("102030").build());

        var response = usuarioRepository.findAll();
        if(Objects.nonNull(response))
            return ResponseEntity.ok(response);
        return ResponseEntity.noContent().build();
    }
}
