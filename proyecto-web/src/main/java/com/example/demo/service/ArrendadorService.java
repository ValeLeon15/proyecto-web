package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ArrendadorDTO;
import com.example.demo.entity.Arrendador;
import com.example.demo.repository.ArrendadorRepository;

@Service
public class ArrendadorService {
    //crear cada metodo que va a resolver, por cada clase minimo 5 (encontrar por id, guardar, acutilizar, eliminar, traer todos)
    //siempre retornar un dto
    ArrendadorRepository arrendadorRepository;
    ModelMapper modelMapper; 
    //constructor para poder usar el arrendadorRepository
    @Autowired //inyeccion de dependencias
    ArrendadorService(ArrendadorRepository arrendadorRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.arrendadorRepository = arrendadorRepository;
    }
    public ArrendadorDTO get(Long id) {
        Optional<Arrendador> arrendadorOpt = arrendadorRepository.findById(id);
        ArrendadorDTO arrendadorDTO = null;
        if(arrendadorOpt.isPresent()) { //si el arrendador existe no habra null
            Arrendador arrendador = arrendadorOpt.get();
            arrendadorDTO = modelMapper.map(arrendador, ArrendadorDTO.class); //con esta linea paso de la entidad al dto
        }
        return arrendadorDTO;
    }

    public List<ArrendadorDTO> get() {
        List<Arrendador> arrendadores = ( List<Arrendador>)arrendadorRepository.findAll();
        List<ArrendadorDTO> arrendadorDTOs = arrendadores.stream()
                .map(arrendador -> modelMapper.map(arrendador, ArrendadorDTO.class))
                .collect(Collectors.toList());
        return arrendadorDTOs;
    }

    public ArrendadorDTO save(ArrendadorDTO arrendadorDTO) {
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);
        return modelMapper.map(arrendador, ArrendadorDTO.class);
    }

    public ArrendadorDTO update(ArrendadorDTO arrendadorDTO) { //para que no cree un estudiante nuevo, estudianteDTO el id debe ser diferente a null 
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);
        return modelMapper.map(arrendador, ArrendadorDTO.class);
    }

    public void delete(Long id) { //
       arrendadorRepository.deleteById(id);
    }
}
