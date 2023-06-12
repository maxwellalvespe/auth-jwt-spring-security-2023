package com.estudo.autenticacao.auth.services;

import com.estudo.autenticacao.auth.model.Usuario;
import com.estudo.autenticacao.auth.services.exception.UsuarioInexistenteException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AutenticationService implements UserDetailsService {

    //Caso acesse a base de dados injetar no construtor , porém irei mocar os dados
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (isNull(username))
            throw new UsuarioInexistenteException("Usuario não localizado na base de dados!");
        return new Usuario(1l,username, new BCryptPasswordEncoder().encode("123"));
    }


}
