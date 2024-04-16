package com.example.demo.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@SQLDelete(sql = "DELETE FROM propiedad WHERE id=?")
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
    private int arrendadorId; //esta mal
}
