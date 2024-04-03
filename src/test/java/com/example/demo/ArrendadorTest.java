package com.example.demo;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controllers.ArrendadorController;
import com.example.demo.dto.ArrendadorDTO;

@SpringBootTest
public class ArrendadorTest {
    @Autowired
    ArrendadorController arrendadorController;
    @Test
    void arrendadorTest(){
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        int cantidad = arrendadorController.get().size();
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(null, "nombre", "apellido", "email", "contraseña", 3434);
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
