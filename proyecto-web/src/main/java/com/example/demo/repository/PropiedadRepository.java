package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Propiedad;

public interface PropiedadRepository extends CrudRepository <Propiedad,Long>{

    List<Propiedad> findByArrendadorId(Long id);

}
