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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Arrendador;
import com.example.demo.repository.ArrendadorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="")
public class ArrendadorControlador {

    @Autowired
    private ArrendadorRepository arrendadorRepository;

    @CrossOrigin
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Arrendador> get( ) throws Exception{
        return (List<Arrendador>) arrendadorRepository.findAll();
    }
    @CrossOrigin
    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Arrendador get( @PathVariable Long id ) throws Exception{
        return arrendadorRepository.findById(id).get();
    }
    @CrossOrigin
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Arrendador save( @RequestBody Arrendador application ) throws Exception {
        return arrendadorRepository.save(application);
    }

    @CrossOrigin
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Arrendador update( @RequestBody Arrendador application ) throws Exception {
        return arrendadorRepository.save(application);
    }
    
    @CrossOrigin
    @DeleteMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete( @PathVariable Long id ) throws Exception {
        arrendadorRepository.deleteById(id);
    }
}
