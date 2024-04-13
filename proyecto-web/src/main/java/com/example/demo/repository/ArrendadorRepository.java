package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Arrendador;


public interface ArrendadorRepository extends CrudRepository <Arrendador,Long> { 

}
