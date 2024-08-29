package com.br.csousa.organizationForAll.services;

import com.br.csousa.organizationForAll.models.Usuario;
import com.br.csousa.organizationForAll.models.request.RequestUserCreate;
import com.br.csousa.organizationForAll.repositorys.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public Usuario save(RequestUserCreate user) {
        return userRepository.save(convert(user));
    }


    private Usuario convert(RequestUserCreate user) {

        return Usuario.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();
    }
}
