package com.ismaelmaldonado.final_servidor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.services.cliente.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService service;

    @BeforeEach
    public void setup() {
        Cliente cliente = new Cliente("Juan", "Perez");
        when(service.getClienteById(1)).thenReturn(cliente);
        when(service.listAllClients()).thenReturn(Arrays.asList(cliente));
    }

    @Test
    public void testGetListTodosLosClientes() throws Exception {
        mockMvc.perform(get("/cliente"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")))
                .andExpect(jsonPath("$[0].apellido", is("Perez")));
    }

    @Test
    public void testGetClienteById() throws Exception {
        mockMvc.perform(get("/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Perez")));
    }

    @Test
    public void testGetClientesByApellido() throws Exception {
        Cliente cliente1 = new Cliente("Juan", "Perez");
        Cliente cliente2 = new Cliente("Pedro", "Perez");
        when(service.getClientesByApellido("Perez")).thenReturn(Arrays.asList(cliente1, cliente2));

        mockMvc.perform(get("/cliente/detalle/Perez"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")))
                .andExpect(jsonPath("$[1].nombre", is("Pedro")));
    }

    @Test
    public void testDeleteClienteById() throws Exception {
        doNothing().when(service).deleteClienteById(1);

        mockMvc.perform(delete("/cliente/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente("Juan", "Perez");
        doNothing().when(service).createClient(any(Cliente.class));

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Juan\",\"apellido\":\"Perez\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateClienteWithPathVariable() throws Exception {
        Cliente cliente = new Cliente("Juan", "Perez");
        doNothing().when(service).createClient(any(Cliente.class));

        mockMvc.perform(post("/cliente/Juan/Perez"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateClienteById() throws Exception {
        doNothing().when(service).updateClienteById(1, "Juan", "Perez");

        mockMvc.perform(put("/cliente/1/Juan/Perez"))
                .andExpect(status().isOk());
    }

}
