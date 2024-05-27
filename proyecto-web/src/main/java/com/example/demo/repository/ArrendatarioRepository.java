package com.example.demo.repository;

import com.example.demo.entity.Arrendador;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Arrendatario;

import java.util.Optional;

public interface ArrendatarioRepository  extends CrudRepository<Arrendatario,Long>{
    Optional<Arrendatario> findByCorreo(String correo);
}
