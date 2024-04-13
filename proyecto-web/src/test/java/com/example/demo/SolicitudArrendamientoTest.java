package com.example.demo;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.SolicitudArrendamientoController;
import com.example.demo.dto.solicitudArrendamientoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolicitudArrendamientoTest {
    
    @Autowired
    SolicitudArrendamientoController solicitudArrendamientoController;

    @Test
    public void solicitudArrendamientoTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Verificar la cantidad de solicitudes de arrendamiento antes de guardar una nueva
        int cantidadAntes = solicitudArrendamientoController.get().size();
        
        // Guardar una nueva solicitud de arrendamiento
        solicitudArrendamientoDTO solicitudDTO = new solicitudArrendamientoDTO(null, 1, 1, 1, new Date(), new Date(), 2, "Pendiente");
        solicitudDTO = solicitudArrendamientoController.save(solicitudDTO);
        
        // Verificar que se haya guardado correctamente
        int cantidadDespuesGuardar = solicitudArrendamientoController.get().size();
        Assert.assertEquals(cantidadAntes + 1, cantidadDespuesGuardar);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Actualizar el estado de la solicitud de arrendamiento
        solicitudDTO.setEstado("Aceptada");
        solicitudArrendamientoController.update(solicitudDTO);
        
        // Verificar que se haya actualizado correctamente
        solicitudArrendamientoDTO solicitudActualizadaDTO = solicitudArrendamientoController.get(solicitudDTO.getId());
        Assert.assertEquals("Aceptada", solicitudActualizadaDTO.getEstado());

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        // Eliminar la solicitud de arrendamiento
        solicitudArrendamientoController.delete(solicitudDTO.getId());
        
        // Verificar que se haya eliminado correctamente
        int cantidadDespuesEliminar = solicitudArrendamientoController.get().size();
        Assert.assertEquals(cantidadAntes, cantidadDespuesEliminar);
    }
}

