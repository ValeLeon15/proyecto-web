package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrendadorDTO {
   
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private int telefono;
}
