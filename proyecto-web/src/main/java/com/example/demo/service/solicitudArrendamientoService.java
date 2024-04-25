package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.ArrendatarioController;
import com.example.demo.controllers.PropiedadController;
import com.example.demo.dto.ArrendatarioDTO;
import com.example.demo.dto.PropiedadDTO;
import com.example.demo.dto.solicitudArrendamientoDTO;
import com.example.demo.entity.Arrendatario;
import com.example.demo.entity.Propiedad;
import com.example.demo.entity.solicitudArrendamiento;
import com.example.demo.repository.solicitudArrendamientoRepository;

@Service
public class solicitudArrendamientoService {

    @Autowired
    ArrendatarioController arrendatarioController;
    @Autowired
    PropiedadController propiedadController;
    solicitudArrendamientoRepository solicitudArrendamientoRepository;
    ModelMapper modelMapper;

    @Autowired
    solicitudArrendamientoService(solicitudArrendamientoRepository solicitudArrendamientoRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.solicitudArrendamientoRepository = solicitudArrendamientoRepository;
    }

    public solicitudArrendamientoDTO get(Long id) {
        Optional<solicitudArrendamiento> solicitudArrendamientoOpt = solicitudArrendamientoRepository.findById(id);
        solicitudArrendamientoDTO solicitudArrendamientoDTO = null;
        if (solicitudArrendamientoOpt.isPresent()) {
            solicitudArrendamiento solicitudArrendamiento = solicitudArrendamientoOpt.get();
            solicitudArrendamientoDTO = convertToDTO(solicitudArrendamiento);
        }
        return solicitudArrendamientoDTO;
    }

    public List<solicitudArrendamientoDTO> get() {
        List<solicitudArrendamiento> solicitudesArrendamiento = (List<solicitudArrendamiento>) solicitudArrendamientoRepository.findAll();
        return solicitudesArrendamiento.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private solicitudArrendamientoDTO convertToDTO(solicitudArrendamiento solicitudArrendamiento) {
        solicitudArrendamientoDTO solicitudArrendamientoDTO = modelMapper.map(solicitudArrendamiento, solicitudArrendamientoDTO.class);
        solicitudArrendamientoDTO.setIdPropiedad(solicitudArrendamiento.getPropiedad().getId());
        solicitudArrendamientoDTO.setIdArrendatario(solicitudArrendamiento.getArrendatario().getId());
        return solicitudArrendamientoDTO;
    }

    public solicitudArrendamientoDTO save(solicitudArrendamientoDTO solicitudArrendamientoDTO, Long idPropiedad, Long idArrendatario) {
        // Verificar si la propiedad existe
        PropiedadDTO propiedadDTO = propiedadController.get(idPropiedad);
        if (propiedadDTO == null) {
            throw new RuntimeException("Propiedad no encontrada con el ID: " + idPropiedad);
        }

        // Verificar si el arrendatario existe
        ArrendatarioDTO arrendatarioDTO = arrendatarioController.get(idArrendatario);
        if (arrendatarioDTO == null) {
            throw new RuntimeException("Arrendatario no encontrado con el ID: " + idArrendatario);
        }

        // Mapear el DTO de la solicitud de arrendamiento a la entidad
        solicitudArrendamiento solicitudArrendamiento = modelMapper.map(solicitudArrendamientoDTO, solicitudArrendamiento.class);
        
        // Obtener la entidad de la propiedad y asignarla a la solicitud de arrendamiento
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        solicitudArrendamiento.setPropiedad(propiedad);
        
        // Obtener la entidad del arrendatario y asignarla a la solicitud de arrendamiento
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        solicitudArrendamiento.setArrendatario(arrendatario);
        
        // Guardar la solicitud de arrendamiento en la base de datos
        solicitudArrendamiento = solicitudArrendamientoRepository.save(solicitudArrendamiento);
        
        // Mapear la solicitud de arrendamiento guardada a DTO y devolverla
        return modelMapper.map(solicitudArrendamiento, solicitudArrendamientoDTO.class);
    }

    public solicitudArrendamientoDTO update(solicitudArrendamientoDTO solicitudArrendamientoDTO) {
        solicitudArrendamiento solicitudArrendamiento = modelMapper.map(solicitudArrendamientoDTO, solicitudArrendamiento.class);
        solicitudArrendamiento = solicitudArrendamientoRepository.save(solicitudArrendamiento);
        return modelMapper.map(solicitudArrendamiento, solicitudArrendamientoDTO.class);
    }

    public void delete(Long id) {
        solicitudArrendamientoRepository.deleteById(id);
    }
    
    public List<solicitudArrendamientoDTO> getSolicitudesByArrendatarioId(Long id) {
        List<solicitudArrendamiento> solicitudesArrendamiento = solicitudArrendamientoRepository.findByArrendatarioId(id);
        List<solicitudArrendamientoDTO> solicitudArrendamientoDTOs = solicitudesArrendamiento.stream()
                .map(solicitudArrendamiento -> modelMapper.map(solicitudArrendamiento, solicitudArrendamientoDTO.class))
                .collect(Collectors.toList());
        return solicitudArrendamientoDTOs;
    }
}
