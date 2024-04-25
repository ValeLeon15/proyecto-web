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

import com.example.demo.dto.solicitudArrendamientoDTO;
import com.example.demo.service.solicitudArrendamientoService;

@RestController
@RequestMapping(value="/progrupo14/solicitudarrendamiento") // La ruta tiene el nombre en minúscula
@CrossOrigin(origins = "http://localhost")
public class SolicitudArrendamientoController {

    solicitudArrendamientoService solicitudArrendamientoService;

    @Autowired
    SolicitudArrendamientoController(solicitudArrendamientoService solicitudArrendamientoService){
        this.solicitudArrendamientoService = solicitudArrendamientoService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public solicitudArrendamientoDTO get(@PathVariable Long id){
        return solicitudArrendamientoService.get(id);
    }
    
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<solicitudArrendamientoDTO> get(){
        return solicitudArrendamientoService.get();
    }
    
    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public solicitudArrendamientoDTO save(@RequestBody solicitudArrendamientoDTO solicitudArrendamientoDTO){
        return solicitudArrendamientoService.save(solicitudArrendamientoDTO);
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public solicitudArrendamientoDTO update(@RequestBody solicitudArrendamientoDTO solicitudArrendamientoDTO) {
        return solicitudArrendamientoService.update(solicitudArrendamientoDTO);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        solicitudArrendamientoService.delete(id);
    }

    //obtener solicitud de arrendamiento según idUsuarioArrendatario
    @CrossOrigin
    @GetMapping(value = "/arrendatario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<solicitudArrendamientoDTO> getSolicitudesArrendatario(@PathVariable Long id){
        return solicitudArrendamientoService.getSolicitudesByArrendatarioId(id);
    }
}
