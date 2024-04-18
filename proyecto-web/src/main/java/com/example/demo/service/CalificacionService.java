package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CalificacionDTO;
import com.example.demo.dto.PropiedadDTO;
import com.example.demo.entity.Calificacion;
import com.example.demo.entity.Propiedad;
import com.example.demo.repository.CalificacionRepository;

@Service
public class CalificacionService {

    CalificacionRepository calificacionRepository;
    ModelMapper modelMapper;

    @Autowired
    CalificacionService(CalificacionRepository calificacionRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.calificacionRepository = calificacionRepository;
    }

    public CalificacionDTO get(Long id) {
        Optional<Calificacion> calificacionOpt = calificacionRepository.findById(id);
        CalificacionDTO calificacionDTO = null;
        if (calificacionOpt.isPresent()) {
            Calificacion calificacion = calificacionOpt.get();
            calificacionDTO = modelMapper.map(calificacion, CalificacionDTO.class);
        }
        return calificacionDTO;
    }

    public List<CalificacionDTO> get() {
        List<Calificacion> calificaciones = (List<Calificacion>) calificacionRepository.findAll();
        List<CalificacionDTO> calificacionDTOs = calificaciones.stream()
                .map(calificacion -> modelMapper.map(calificacion, CalificacionDTO.class))
                .collect(Collectors.toList());
        return calificacionDTOs;
    }

    public CalificacionDTO save(CalificacionDTO calificacionDTO) {
        Calificacion calificacion = modelMapper.map(calificacionDTO, Calificacion.class);
        calificacion = calificacionRepository.save(calificacion);
        return modelMapper.map(calificacion, CalificacionDTO.class);
    }

    public CalificacionDTO update(CalificacionDTO calificacionDTO) {
        Calificacion calificacion = modelMapper.map(calificacionDTO, Calificacion.class);
        calificacion = calificacionRepository.save(calificacion);
        return modelMapper.map(calificacion, CalificacionDTO.class);
    }

    public void delete(Long id) {
        calificacionRepository.deleteById(id);
    }

    public List<CalificacionDTO> getCalificacionBySolicitud(Long id) {
        List<Calificacion> calificaciones = calificacionRepository.findBySolicitudArrendamientoId(id);
        System.out.println("Calificaciones" + calificaciones.toString());
        List<CalificacionDTO> calificacionDTOs = calificaciones.stream()
                .map(calificacion -> modelMapper.map(calificacion, CalificacionDTO.class))
                .collect(Collectors.toList());
        return calificacionDTOs;
    }
}
