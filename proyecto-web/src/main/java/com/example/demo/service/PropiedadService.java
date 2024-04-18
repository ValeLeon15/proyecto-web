package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PropiedadDTO;
import com.example.demo.entity.Propiedad;
import com.example.demo.repository.PropiedadRepository;

@Service
public class PropiedadService {

    PropiedadRepository propiedadRepository;
    ModelMapper modelMapper;

    @Autowired
    PropiedadService(PropiedadRepository propiedadRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.propiedadRepository = propiedadRepository;
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

    public PropiedadDTO save(PropiedadDTO propiedadDTO) {
        System.out.println("propiedadDTO: " + propiedadDTO.toString());
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        propiedad = propiedadRepository.save(propiedad);
        return modelMapper.map(propiedad, PropiedadDTO.class);
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

