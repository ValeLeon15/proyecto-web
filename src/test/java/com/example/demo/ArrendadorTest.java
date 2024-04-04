package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
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

        int cantidad = arrendadorController.get().size();
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(null, "nombre", "apellido", "correo", "contraseña", 3434);
        arrendadorDTO = arrendadorController.save(arrendadorDTO);
        int nuevaCantidad = arrendadorController.get().size();
        Assert.assertEquals(cantidad + 1, nuevaCantidad);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        arrendadorDTO.setNombre("nombre2");
        arrendadorController.update(arrendadorDTO);
        ArrendadorDTO arrendadorActualizadoDTO = arrendadorController.get(arrendadorDTO.getId());
        Assert.assertEquals("nombre2", arrendadorActualizadoDTO.getNombre());
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
    }
}
