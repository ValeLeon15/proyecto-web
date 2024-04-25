package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.ArrendadorController;
import com.example.demo.dto.ArrendadorDTO;
import com.example.demo.dto.PropiedadDTO;
import com.example.demo.entity.Arrendador;
import com.example.demo.entity.Propiedad;
import com.example.demo.repository.PropiedadRepository;
import com.example.demo.repository.ArrendadorRepository;

@Service
public class PropiedadService {

    PropiedadRepository propiedadRepository;

    @Autowired
    ArrendadorController arrendadorController;
    ModelMapper modelMapper;

    @Autowired
    PropiedadService(PropiedadRepository propiedadRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.propiedadRepository = propiedadRepository;  
        
    }

    public PropiedadDTO saveWithArrendador(PropiedadDTO propiedadDTO, Long arrendadorId) {
        // Obtener el arrendador por su ID utilizando el controlador ArrendadorController
        ArrendadorDTO arrendadorDTO = arrendadorController.get(arrendadorId);
        
        // Verificar si se encontró el arrendador
        if (arrendadorDTO == null) {
            throw new RuntimeException("Arrendador no encontrado con el ID: " + arrendadorId);
        }
        
        // Mapear el DTO de la propiedad a la entidad Propiedad
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        
        // Mapear el DTO del arrendador a la entidad Arrendador
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        
        // Establecer el arrendador en la propiedad
        propiedad.setArrendador(arrendador);
        
        // Guardar la propiedad en la base de datos
        propiedad = propiedadRepository.save(propiedad);
        
        // Mapear la propiedad guardada a DTO y devolverla
        return modelMapper.map(propiedad, PropiedadDTO.class);
    }

    public PropiedadDTO get(Long id) {
        Optional<Propiedad> propiedadOpt = propiedadRepository.findById(id);
        PropiedadDTO propiedadDTO = null;
        if (propiedadOpt.isPresent()) {
            Propiedad propiedad = propiedadOpt.get();
            propiedadDTO = modelMapper.map(propiedad, PropiedadDTO.class);
        }
        return propiedadDTO;
    }

    public List<PropiedadDTO> get() {
        List<Propiedad> propiedades = (List<Propiedad>) propiedadRepository.findAll();
        List<PropiedadDTO> propiedadDTOs = propiedades.stream()
                .map(propiedad -> modelMapper.map(propiedad, PropiedadDTO.class))
                .collect(Collectors.toList());
        return propiedadDTOs;
    }    

    public PropiedadDTO update(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        propiedad = propiedadRepository.save(propiedad);
        return modelMapper.map(propiedad, PropiedadDTO.class);
    }

    public void delete(Long id) {
        propiedadRepository.deleteById(id);
    }
     
    public List<PropiedadDTO> getPropiedadesByArrendador(Long id) {
        List<Propiedad> propiedades = propiedadRepository.findByArrendadorId(id);
        System.out.println("Propiedades" + propiedades.toString());
        List<PropiedadDTO> propiedadDTOs = propiedades.stream()
                .map(propiedad -> modelMapper.map(propiedad, PropiedadDTO.class))
                .collect(Collectors.toList());
        return propiedadDTOs;
    }
}

