package com.br.csousa.organizationForAll.services;


import com.br.csousa.organizationForAll.models.Usuario;
import com.br.csousa.organizationForAll.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario uservalidation = userRepository.findByUsername(username);
        if(uservalidation != null){
            return User.withUsername(uservalidation.getUsername())
                    .password(uservalidation.getPassword())
                    .authorities(new SimpleGrantedAuthority(uservalidation.getRole()))
                    .build();
        }else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }
}
