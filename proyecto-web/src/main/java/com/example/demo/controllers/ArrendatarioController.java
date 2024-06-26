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

import com.example.demo.dto.ArrendatarioDTO;
import com.example.demo.service.ArrendatarioService;

@RestController
@RequestMapping(value="/progrupo14/arrendatarios")
@CrossOrigin(origins = "http://localhost")
public class ArrendatarioController {

    ArrendatarioService arrendatarioService;

    @Autowired
    ArrendatarioController(ArrendatarioService arrendatarioService){
        this.arrendatarioService = arrendatarioService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO get(@PathVariable Long id){
        return arrendatarioService.get(id);
    }
    
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendatarioDTO> get(){
        return arrendatarioService.get();
    }
    
    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO save(@RequestBody ArrendatarioDTO arrendatarioDTO){
        return arrendatarioService.save(arrendatarioDTO);
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO update(@RequestBody ArrendatarioDTO arrendatarioDTO) {
        return arrendatarioService.update(arrendatarioDTO);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        arrendatarioService.delete(id);
    }
}
