package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.PropiedadController;
import com.example.demo.dto.PropiedadDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropiedadTest {
    
    @Autowired
    PropiedadController propiedadController;

    @Test
    public void propiedadTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Verificar la cantidad de propiedades antes de guardar una nueva
        int cantidadAntes = propiedadController.get().size();
        
        // Guardar una nueva propiedad
        PropiedadDTO propiedadDTO = new PropiedadDTO(null, "Casa de campo", "Medellín", "Antioquia", "Alquiler", "Hermosa casa de campo con vista a las montanas", 4, 2, true, true, false, 150000, 5);
        propiedadDTO = propiedadController.save(propiedadDTO);
        
        // Verificar que se haya guardado correctamente
        int cantidadDespuesGuardar = propiedadController.get().size();
        Assert.assertEquals(cantidadAntes + 1, cantidadDespuesGuardar);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Actualizar la descripción de la propiedad
        propiedadDTO.setDescripcion("Acogedora casa de campo con vista a las montañas");
        propiedadController.update(propiedadDTO);
        
        // Verificar que se haya actualizado correctamente
        PropiedadDTO propiedadActualizadaDTO = propiedadController.get(propiedadDTO.getId());
        Assert.assertEquals("Acogedora casa de campo con vista a las montañas", propiedadActualizadaDTO.getDescripcion());

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        // Eliminar la propiedad
        propiedadController.delete(propiedadDTO.getId());
        
        // Verificar que se haya eliminado correctamente
        int cantidadDespuesEliminar = propiedadController.get().size();
        Assert.assertEquals(cantidadAntes, cantidadDespuesEliminar);
    }
}

