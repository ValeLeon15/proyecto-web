package com.example.demo.auth;


import com.example.demo.entity.Arrendador;
import com.example.demo.entity.Arrendatario;
import com.example.demo.repository.ArrendadorRepository;
import com.example.demo.repository.ArrendatarioRepository;
import com.example.demo.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService {
    @Autowired
    private ArrendadorRepository arrendadorRepository;
    @Autowired
    private ArrendatarioRepository arrendatarioRepository;
    //con el JwtService se le pasa el token ya sea para validar o para extraer el usuario
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest loginRequest) {
        //se busca el usuario por el nombre de usuario
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(loginRequest.getEmail());
        //buscamos el arrendador o arrendatario
        final Arrendador arrendador = arrendadorRepository.findByCorreo(loginRequest.getEmail()).orElse(null);
        final Arrendatario arrendatario = arrendatarioRepository.findByCorreo(loginRequest.getEmail()).orElse(null);
        if (arrendador != null) {
            final String token = jwtService.generateToken(userDetails);
            return new AuthResponse(arrendador.getId(), token, arrendador.getUsername(), arrendador.getTipo());
        } else if (arrendatario != null) {
            final String token = jwtService.generateToken(userDetails);
            return new AuthResponse(arrendatario.getId(), token, arrendatario.getUsername(), arrendatario.getTipo());
        } else {
            throw new IllegalArgumentException("Invalid email or password.");
        }
    }
    public AuthResponse registerArrendador(RegisterRequest registerRequest) {
        Arrendador user = new Arrendador(registerRequest.nombre,
                registerRequest.apellido,
                registerRequest.correo,
                passwordEncoder.encode(registerRequest.contrasena),
                registerRequest.telefono, registerRequest.tipo.toUpperCase());
        arrendadorRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(user.getId(), jwt, user.getUsername(), user.getTipo());
    }

    public AuthResponse registerArrendatario(RegisterRequest registerRequest) {
        Arrendatario user = new Arrendatario(registerRequest.nombre,
                registerRequest.apellido,
                registerRequest.correo,
                passwordEncoder.encode(registerRequest.contrasena),
                registerRequest.telefono, registerRequest.tipo.toUpperCase());
        arrendatarioRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(user.getId(), jwt, user.getUsername(), user.getTipo());
    }
}
