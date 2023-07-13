package com.estudo.autenticacao.auth.encodesenhadb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EncodePasswordDb {

    @Test
    @DisplayName("Should password matcher")
    void encode(){
        assertNotEquals("$2a$10$7WUlWF7T1TaPbWrdg6DBnOmJxsDAO/m7dN1.o8yw07NdCh2HsPtM.",new BCryptPasswordEncoder().encode("123"));
    }
}
