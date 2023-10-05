package com.ismaelmaldonado.final_servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.services.vehiculo.VehiculoService;

/**
 * Controlador que gestiona las operaciones relacionadas con la entidad
 * Vehiculo.
 */
@RestController
public class VehiculoController {

    // Inyección de dependencia del servicio VehiculoService.
    @Autowired
    private VehiculoService service;

    /**
     * Endpoint que devuelve una lista con todos los vehículos.
     * 
     * @return Lista de vehículos.
     */
    @GetMapping(value = "/vehiculo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getListTodosLosVehiculos() {
        return service.listAllVehicles();
    }

    /**
     * Endpoint que devuelve un vehículo específico según su ID.
     * 
     * @param id ID del vehículo a recuperar.
     * @return Vehículo buscado.
     */
    @GetMapping(value = "/vehiculo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoById(@PathVariable int id) {
        return service.getVehiculoById(id);
    }

    /**
     * Endpoint que devuelve el dueño de un vehículo específico según el ID del
     * vehículo.
     * 
     * @param id ID del vehículo.
     * @return Cliente dueño del vehículo.
     */
    @GetMapping(value = "/vehiculo/dueño/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteByVehiculoId(@PathVariable int id) {
        return service.getClienteByVehiculoId(id);
    }

    /**
     * Endpoint que devuelve un vehículo según su matrícula.
     * 
     * @param matricula Matrícula del vehículo.
     * @return Vehículo buscado.
     */
    @GetMapping(value = "/vehiculo/detalle/matricula/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoByMatricula(@PathVariable String matricula) {
        return service.getVehiculoByMatricula(matricula);
    }

    /**
     * Endpoint que devuelve una lista de vehículos según el fabricante.
     * 
     * @param nombreFabricante Nombre del fabricante de los vehículos.
     * @return Lista de vehículos del fabricante especificado.
     */
    @GetMapping(value = "/vehiculo/detalle/{nombreFabricante}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByFabricante(@PathVariable String nombreFabricante) {
        return service.getVehiculosByFabricante(nombreFabricante);
    }

    /**
     * Endpoint para eliminar un vehículo según su ID.
     * 
     * @param id ID del vehículo a eliminar.
     */
    @DeleteMapping(value = "/vehiculo/{id}")
    public void deleteVehiculoById(@PathVariable int id) {
        service.deleteVehiculoById(id);
    }

    /**
     * Endpoint para actualizar la matrícula de un vehículo específico.
     * 
     * @param id        ID del vehículo a actualizar.
     * @param matricula Nueva matrícula para el vehículo.
     */
    @PutMapping(value = "/vehiculo/{id}/{matricula}")
    public void updateVehiculoById(@PathVariable int id, @PathVariable String matricula) {
        service.updateVehiculoById(id, matricula);
    }

    /**
     * Endpoint para crear un nuevo vehículo asociado a un cliente específico.
     * 
     * @param vehiculo Objeto vehículo a crear.
     * @param id       ID del cliente al que se asocia el vehículo.
     */
    @PostMapping(value = "/vehiculo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable int id) {
        service.createVehiculo(vehiculo, id);
    }

}
