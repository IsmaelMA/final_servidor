package com.ismaelmaldonado.final_servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.services.cliente.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getListTodosLosClientes() {
        return service.listAllClients();
    }

    @GetMapping(value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteById(@PathVariable("id") int id) {
        return service.getClienteById(id);
    }

    @GetMapping(value = "/cliente/detalle/{apellido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getClientesByApellido(@PathVariable("apellido") String apellido) {
        return service.getClientesByApellido(apellido);
    }

    @GetMapping(value = "/cliente/{id}/vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByClienteId(@PathVariable("id") int id) {
        return service.listAllVehiclesOwnedByClient(id);
    }

    @DeleteMapping(value = "/cliente/{id}")
    public void deleteClienteById(@PathVariable("id") int id) {
        service.deleteClienteById(id);
    }

    @PostMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCliente(@RequestBody Cliente cliente) {
        service.createClient(cliente);
    }

    @PutMapping(value = "/cliente/{id}/{nombre}/{apellido}")
    public void updateClienteById(@PathVariable("id") int id, @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        service.updateClienteById(id, nombre, apellido);
    }

}
