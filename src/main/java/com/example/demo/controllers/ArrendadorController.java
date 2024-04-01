package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArrendadorDTO;
import com.example.demo.service.ArrendadorService;

@RestController
@RequestMapping(value="/progrupo14/arrendadores")
//no poner en un controlador un repository
public class ArrendadorController {
    //endpoints, metodos por cada elemento del crud
    ArrendadorService arrendadorService;

    @Autowired
    ArrendadorController (ArrendadorService arrendadorService){
        this.arrendadorService = arrendadorService;
    }

    @CrossOrigin
    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO get( @PathVariable Long id ){
        return arrendadorService.get(id); //solo esto porque la logica ya esta en el service
    }
    
    @CrossOrigin
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendadorDTO> get( ){
        return arrendadorService.get();
    }
   
    @CrossOrigin
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO save( @RequestBody ArrendadorDTO arrendadorDTO){ //va a venir un json en la peticion y lo va a convertir en un objeto
        return arrendadorService.save(arrendadorDTO);
    }

    @CrossOrigin
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO update( @RequestBody ArrendadorDTO arrendadorDTO) {
        return arrendadorService.update(arrendadorDTO);
    }

    @CrossOrigin
    @DeleteMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete( @PathVariable Long id ){
        arrendadorService.delete(id);
    }
}
