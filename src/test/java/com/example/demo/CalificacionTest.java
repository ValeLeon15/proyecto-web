package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controllers.CalificacionController;
import com.example.demo.dto.CalificacionDTO;

import java.util.Date; // Importar la clase Date

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalificacionTest {
    
    @Autowired
    CalificacionController calificacionController;

    @Test
    public void calificacionTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Verificar la cantidad de calificaciones antes de guardar una nueva
        int cantidadAntes = calificacionController.getAll().size();
        
        // Guardar una nueva calificación
        CalificacionDTO calificacionDTO = new CalificacionDTO(null, 1L, 5, "Buen arrendatario", 4, "Buena propiedad", new Date());
        calificacionDTO = calificacionController.save(calificacionDTO);
        
        // Verificar que se haya guardado correctamente
        int cantidadDespuesGuardar = calificacionController.getAll().size();
        Assert.assertEquals(cantidadAntes + 1, cantidadDespuesGuardar);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Actualizar la calificación del arrendatario
        calificacionDTO.setCalificacionArrendatario(4);
        calificacionController.update(calificacionDTO);
        
        // Verificar que se haya actualizado correctamente
        CalificacionDTO calificacionActualizadaDTO = calificacionController.get(calificacionDTO.getId());
        Assert.assertEquals(4, calificacionActualizadaDTO.getCalificacionArrendatario());

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        // Eliminar la calificación
        calificacionController.delete(calificacionDTO.getId());
        
        // Verificar que se haya eliminado correctamente
        int cantidadDespuesEliminar = calificacionController.getAll().size();
        Assert.assertEquals(cantidadAntes, cantidadDespuesEliminar);
    }
}
