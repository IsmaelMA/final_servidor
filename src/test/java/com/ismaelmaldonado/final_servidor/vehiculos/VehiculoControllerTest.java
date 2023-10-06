package com.ismaelmaldonado.final_servidor.vehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.ismaelmaldonado.final_servidor.controller.VehiculoController;
import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.services.vehiculo.VehiculoService;

public class VehiculoControllerTest {

    @Mock
    private VehiculoService service;

    @InjectMocks
    private VehiculoController controller;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVehiculosByFabricante() {
        String fabricante = "Ford";
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", "1234ABC"));
        vehiculos.add(new Vehiculo("Focus", "Ford", "5678DEF"));
        when(service.getVehiculosByFabricante(fabricante)).thenReturn(vehiculos);

        ResponseEntity<List<Vehiculo>> response = (ResponseEntity<List<Vehiculo>>) controller
                .getVehiculosByFabricante(fabricante);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vehiculos, response.getBody());
    }

    @Test
    public void testUpdateVehiculoById() {
        int id = 1;
        String matricula = "4321ZYX";

        controller.updateVehiculoById(id, matricula);

        ResponseEntity<Void> response = ResponseEntity.noContent().build();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}