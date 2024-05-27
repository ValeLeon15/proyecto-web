package com.example.demo.auth;

import com.example.demo.entity.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    Long id;
    String token;
    private String correo;
    private TipoUsuario role;
}
