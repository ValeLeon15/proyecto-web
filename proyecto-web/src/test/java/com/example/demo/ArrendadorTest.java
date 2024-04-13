package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.ArrendadorController;
import com.example.demo.dto.ArrendadorDTO;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ArrendadorTest {
    
    @Autowired
    ArrendadorController arrendadorController;

    @Test
    public void arrendadorTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Verificar la cantidad de arrendadores antes de guardar uno nuevo
        int cantidadAntes = arrendadorController.get().size();
        
        // Guardar un nuevo arrendador
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(null, "nombre", "apellido", "correo", "contraseña", 3434);
        arrendadorDTO = arrendadorController.save(arrendadorDTO);
        
        // Verificar que se haya guardado correctamente
        int cantidadDespuesGuardar = arrendadorController.get().size();
        Assert.assertEquals(cantidadAntes + 1, cantidadDespuesGuardar);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Actualizar el nombre del arrendador
        arrendadorDTO.setNombre("nombre2");
        arrendadorController.update(arrendadorDTO);
        
        // Verificar que se haya actualizado correctamente
        ArrendadorDTO arrendadorActualizadoDTO = arrendadorController.get(arrendadorDTO.getId());
        Assert.assertEquals("nombre2", arrendadorActualizadoDTO.getNombre());

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        // Eliminar el arrendador
        arrendadorController.delete(arrendadorDTO.getId());
        
        // Verificar que se haya eliminado correctamente
        int cantidadDespuesEliminar = arrendadorController.get().size();
        Assert.assertEquals(cantidadAntes, cantidadDespuesEliminar);
    }
}
