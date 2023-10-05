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

/**
 * Controlador que gestiona las operaciones relacionadas con la entidad Cliente.
 */
@RestController
public class ClienteController {

    // Inyección de dependencia del servicio ClienteService.
    @Autowired
    private ClienteService service;

    /**
     * Endpoint que devuelve una lista con todos los clientes.
     * 
     * @return Lista de clientes.
     */
    @GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getListTodosLosClientes() {
        return service.listAllClients();
    }

    /**
     * Endpoint que devuelve un cliente específico según su ID.
     * 
     * @param id ID del cliente a recuperar.
     * @return Cliente buscado.
     */
    @GetMapping(value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteById(@PathVariable("id") int id) {
        return service.getClienteById(id);
    }

    /**
     * Endpoint que devuelve una lista de clientes según su apellido.
     * 
     * @param apellido Apellido de los clientes a recuperar.
     * @return Lista de clientes con el apellido especificado.
     */
    @GetMapping(value = "/cliente/detalle/{apellido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getClientesByApellido(@PathVariable("apellido") String apellido) {
        return service.getClientesByApellido(apellido);
    }

    /**
     * Endpoint que devuelve una lista de vehículos asociados a un cliente
     * específico.
     * 
     * @param id ID del cliente.
     * @return Lista de vehículos del cliente.
     */
    @GetMapping(value = "/cliente/{id}/vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByClienteId(@PathVariable("id") int id) {
        return service.listAllVehiclesOwnedByClient(id);
    }

    /**
     * Endpoint para eliminar un cliente según su ID.
     * 
     * @param id ID del cliente a eliminar.
     */
    @DeleteMapping(value = "/cliente/{id}")
    public void deleteClienteById(@PathVariable("id") int id) {
        service.deleteClienteById(id);
    }

    /**
     * Endpoint para crear un nuevo cliente.
     * 
     * @param cliente Objeto cliente a crear.
     */
    @PostMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCliente(@RequestBody Cliente cliente) {
        service.createClient(cliente);
    }

    /**
     * Endpoint para actualizar la información de un cliente específico.
     * 
     * @param id       ID del cliente a actualizar.
     * @param nombre   Nuevo nombre para el cliente.
     * @param apellido Nuevo apellido para el cliente.
     */
    @PutMapping(value = "/cliente/{id}/{nombre}/{apellido}")
    public void updateClienteById(@PathVariable("id") int id, @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        service.updateClienteById(id, nombre, apellido);
    }

}
