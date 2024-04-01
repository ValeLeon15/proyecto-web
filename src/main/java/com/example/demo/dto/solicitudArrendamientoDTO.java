package com.example.demo.dto;

import java.util.Date;

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
public class solicitudArrendamientoDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private int idSolicitudArrendamiento;
    private int idPropiedad;
    private int idUsuarioArrendatario;
    private Date fechaInicial;
    private Date fechaFinal;
    private int cantPersonas;
    private String estado;
}
