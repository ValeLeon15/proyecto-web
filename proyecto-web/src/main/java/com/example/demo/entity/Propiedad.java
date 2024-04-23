package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Propiedad {
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

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Arrendador arrendador;
}
