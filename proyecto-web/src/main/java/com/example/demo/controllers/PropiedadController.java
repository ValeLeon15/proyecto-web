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

import com.example.demo.dto.PropiedadDTO;
import com.example.demo.service.PropiedadService;

@RestController
@RequestMapping(value="/progrupo14/propiedad")
@CrossOrigin(origins = "http://localhost")
public class PropiedadController {
    PropiedadService propiedadService;

    @Autowired
    PropiedadController (PropiedadService propiedadService){
        this.propiedadService = propiedadService;
    }

    @CrossOrigin
    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO get( @PathVariable Long id ){
        return propiedadService.get(id);
    }
    
    @CrossOrigin
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> get( ){
        return propiedadService.get();
    }
    
    @CrossOrigin
    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO save(@RequestBody PropiedadDTO propiedadDTO, @PathVariable Long id) {
        System.out.println("propiedadDTO: " + propiedadDTO.toString());
        return propiedadService.saveWithArrendador(propiedadDTO, id);
    }


    @CrossOrigin
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO update( @RequestBody PropiedadDTO propiedadDTO) {
        return propiedadService.update(propiedadDTO);
    }
    
    @CrossOrigin
    @DeleteMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete( @PathVariable Long id ){
        propiedadService.delete(id);
    }

    //"localhost:8080//progrupo14/propiedad/arrendador/{id}"
    //crear un método para que obtenga todos las Propiedades dependiendo de mi id como arrendador
    @CrossOrigin
    @GetMapping( value = "/arrendador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> getPropiedadesArrendador( @PathVariable Long id ){
        return propiedadService.getPropiedadesByArrendador(id);
    }

}
