package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Calificacion;
import java.util.List;


public interface CalificacionRepository extends CrudRepository <Calificacion,Long>  {

    List<Calificacion> findBySolicitudArrendamientoId(Long id);

}
