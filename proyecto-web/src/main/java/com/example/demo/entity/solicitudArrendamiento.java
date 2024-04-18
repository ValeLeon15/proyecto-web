package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.SQLDelete;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

@SQLDelete(sql = "DELETE FROM solicitud_arrendamiento WHERE id=?")
public class solicitudArrendamiento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Propiedad propiedad;

    @ManyToOne
    private Arrendatario arrendatario;

    private Date fechaInicial;
    private Date fechaFinal;
    private int cantPersonas;
    private String estado;

}
