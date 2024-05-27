package com.example.demo.service;

import com.example.demo.entity.Arrendador;
import com.example.demo.entity.Arrendatario;
import com.example.demo.repository.ArrendadorRepository;
import com.example.demo.repository.ArrendatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ArrendadorRepository arrendadorRepository;
    @Autowired
    private ArrendatarioRepository arrendatarioRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String correo) {
                Arrendador arrendador = arrendadorRepository.findByCorreo(correo).orElse(null);
                Arrendatario arrendatario = arrendatarioRepository.findByCorreo(correo).orElse(null);
                if (arrendador != null) {
                    return arrendador;
                } else if (arrendatario != null) {
                    return arrendatario;
                } else {
                    throw new UsernameNotFoundException("Usuario no encontrado");
                }
            }

        };
    }
}
