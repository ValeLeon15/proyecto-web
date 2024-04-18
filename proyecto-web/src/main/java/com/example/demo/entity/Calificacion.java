package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@SQLDelete(sql = "DELETE FROM calificacion WHERE id=?")
public class Calificacion {
    //calificacion del arrendador sobre el arrendatario y del arrendador sobre la propiedad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private solicitudArrendamiento solicitudArrendamiento;

    private int calificacionArrendatario;
    private String comentarioArrendatario;
    private int calificacionPropiedad;
    private String comentarioPropiedad;
    private Date fechaCalificacion;

}
