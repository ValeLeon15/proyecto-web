package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.ArrendatarioController;
import com.example.demo.dto.ArrendatarioDTO;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ArrendatarioTest {
    
    @Autowired
    ArrendatarioController arrendatarioController;

    @Test
    public void arrendatarioTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Verificar la cantidad de arrendatarios antes de guardar uno nuevo
        int cantidadAntes = arrendatarioController.get().size();
        
        // Guardar un nuevo arrendatario
        ArrendatarioDTO arrendatarioDTO = new ArrendatarioDTO(null, "nombre", "apellido", "correo", "contraseña", 785452);
        arrendatarioDTO = arrendatarioController.save(arrendatarioDTO);
        
        // Verificar que se haya guardado correctamente
        int cantidadDespuesGuardar = arrendatarioController.get().size();
        Assert.assertEquals(cantidadAntes + 1, cantidadDespuesGuardar);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Actualizar el nombre del arrendatario
        arrendatarioDTO.setNombre("nombre2");
        arrendatarioController.update(arrendatarioDTO);
        
        // Verificar que se haya actualizado correctamente
        ArrendatarioDTO arrendatarioActualizadoDTO = arrendatarioController.get(arrendatarioDTO.getId());
        Assert.assertEquals("nombre2", arrendatarioActualizadoDTO.getNombre());

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        // Eliminar el arrendatario
        arrendatarioController.delete(arrendatarioDTO.getId());
        
        // Verificar que se haya eliminado correctamente
        int cantidadDespuesEliminar = arrendatarioController.get().size();
        Assert.assertEquals(cantidadAntes, cantidadDespuesEliminar);
    }
}

