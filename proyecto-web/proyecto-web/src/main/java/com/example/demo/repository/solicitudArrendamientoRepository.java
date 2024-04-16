package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.solicitudArrendamiento;

public interface solicitudArrendamientoRepository extends CrudRepository <solicitudArrendamiento,Long> {


    List<solicitudArrendamiento> findByIdUsuarioArrendatario(Long id);
}
