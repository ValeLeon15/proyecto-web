package com.example.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePropiedad;
    private String municipio;
    private String departamento;
    private String tipoIngreso;
    private String descripcion;
    private int cantHabitaciones;
    private int cantBanos;
    private boolean permiteMascotas;
    private boolean tienePiscina;
    private boolean tieneAsador;
    private int valorNoche;
    private int arrendadorId; //esta mal
}
