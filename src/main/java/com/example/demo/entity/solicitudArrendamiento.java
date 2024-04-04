package com.example.demo.entity;

import java.util.Date;

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
@Where(clause = "status = 0")
@SQLDelete(sql = "UPDATE application SET  status = 1 WHERE id=?")
public class solicitudArrendamiento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int idSolicitudArrendamiento;
    private int idPropiedad;
    private int idUsuarioArrendatario;
    private Date fechaInicial;
    private Date fechaFinal;
    private int cantPersonas;
    private String estado;

}
