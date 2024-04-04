package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ArrendatarioDTO;
import com.example.demo.entity.Arrendatario;
import com.example.demo.repository.ArrendatarioRepository;

@Service
public class ArrendatarioService {

    ArrendatarioRepository arrendatarioRepository;
    ModelMapper modelMapper;

    @Autowired
    ArrendatarioService(ArrendatarioRepository arrendatarioRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.arrendatarioRepository = arrendatarioRepository;
    }

    public ArrendatarioDTO get(Long id) {
        Optional<Arrendatario> arrendatarioOpt = arrendatarioRepository.findById(id);
        ArrendatarioDTO arrendatarioDTO = null;
        if (arrendatarioOpt.isPresent()) {
            Arrendatario arrendatario = arrendatarioOpt.get();
            arrendatarioDTO = modelMapper.map(arrendatario, ArrendatarioDTO.class);
        }
        return arrendatarioDTO;
    }

    public List<ArrendatarioDTO> get() {
        List<Arrendatario> arrendatarios = (List<Arrendatario>) arrendatarioRepository.findAll();
        List<ArrendatarioDTO> arrendatarioDTOs = arrendatarios.stream()
                .map(arrendatario -> modelMapper.map(arrendatario, ArrendatarioDTO.class))
                .collect(Collectors.toList());
        return arrendatarioDTOs;
    }

    public ArrendatarioDTO save(ArrendatarioDTO arrendatarioDTO) {
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTO.class);
    }

    public ArrendatarioDTO update(ArrendatarioDTO arrendatarioDTO) {
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTO.class);
    }

    public void delete(Long id) {
        arrendatarioRepository.deleteById(id);
    }
}
