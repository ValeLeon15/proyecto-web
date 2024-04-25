package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.solicitudArrendamientoDTO;
import com.example.demo.entity.solicitudArrendamiento;
import com.example.demo.repository.solicitudArrendamientoRepository;

@Service
public class solicitudArrendamientoService {

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

    public solicitudArrendamientoDTO save(solicitudArrendamientoDTO solicitudArrendamientoDTO) {
        solicitudArrendamiento solicitudArrendamiento = modelMapper.map(solicitudArrendamientoDTO, solicitudArrendamiento.class);
        solicitudArrendamiento = solicitudArrendamientoRepository.save(solicitudArrendamiento);
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
