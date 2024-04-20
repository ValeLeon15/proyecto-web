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

import com.example.demo.dto.CalificacionDTO;
import com.example.demo.service.CalificacionService;

@RestController
@RequestMapping(value="/progrupo14/calificaciones")
@CrossOrigin(origins = "http://localhost")
public class CalificacionController {

    CalificacionService calificacionService;

    @Autowired
    CalificacionController(CalificacionService calificacionService){
        this.calificacionService = calificacionService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionDTO get(@PathVariable Long id){
        return calificacionService.get(id);
    }
    
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CalificacionDTO> getAll(){
        return calificacionService.get();
    }
    
    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionDTO save(@RequestBody CalificacionDTO calificacionDTO){
        return calificacionService.save(calificacionDTO);
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionDTO update(@RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.update(calificacionDTO);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        calificacionService.delete(id);
    }
}
