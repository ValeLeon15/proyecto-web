package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Arrendador;

import java.util.Optional;


public interface ArrendadorRepository extends CrudRepository <Arrendador,Long> {
    Optional<Arrendador> findByCorreo(String correo);
}
