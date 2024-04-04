package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.PropiedadDTO;
import com.example.demo.service.PropiedadService;

public class PropiedadController {
    PropiedadService propiedadService;

    @Autowired
    PropiedadController (PropiedadService propiedadService){
        this.propiedadService = propiedadService;
    }

    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO get( @PathVariable Long id ){
        return propiedadService.get(id);
    }
    
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> get( ){
        return propiedadService.get();
    }
   
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO save( @RequestBody PropiedadDTO propiedadDTO){
        return propiedadService.save(propiedadDTO);
    }

    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO update( @RequestBody PropiedadDTO propiedadDTO) {
        return propiedadService.update(propiedadDTO);
    }
    
    @DeleteMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete( @PathVariable Long id ){
        propiedadService.delete(id);
    }

}
