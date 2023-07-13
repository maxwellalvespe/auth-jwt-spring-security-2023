package com.estudo.autenticacao.auth.domain.services.auth;

import com.estudo.autenticacao.auth.domain.model.Usuario;
import com.estudo.autenticacao.auth.domain.services.exception.UsuarioInexistenteException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class AutenticationService implements UserDetailsService {

    //Caso acesse a base de dados injetar no construtor , porém irei mocar os dados
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (isNull(username))
            throw new UsuarioInexistenteException("Usuario não localizado na base de dados!");
        return new Usuario(UUID.randomUUID(),username, new BCryptPasswordEncoder().encode("123"));
    }


}
