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
public class CalificacionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long idSolicitudArrendamiento;
    private int calificacionArrendatario;
    private String comentarioArrendatario;
    private int calificacionPropiedad;
    private String comentarioPropiedad;
    private Date fechaCalificacion;

}
