package com.ismaelmaldonado.final_servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.services.vehiculo.VehiculoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping(value = "/vehiculo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getListTodosLosVehiculos() {
        return service.listAllVehicles();
    }

    @GetMapping(value = "/vehiculo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoById(@PathVariable int id) {
        return service.getVehiculoById(id);
    }

     @GetMapping(value = "/vehiculo/dueño/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteByVehiculoId(@PathVariable int id) {
        return service.getClienteByVehiculoId(id);
    }

    @GetMapping(value = "/vehiculo/detalle/matricula/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoByMatricula(@PathVariable String matricula) {
        return service.getVehiculoByMatricula(matricula);
    }

    @GetMapping(value = "/vehiculo/detalle/{nombreFabricante}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByFabricante(@PathVariable String nombreFabricante) {
        return service.getVehiculosByFabricante(nombreFabricante);
    }

    @DeleteMapping(value = "/vehiculo/{id}")
    public void deleteVehiculoById(@PathVariable int id) {
        service.deleteVehiculoById(id);
    }

    @PutMapping(value = "/vehiculo/{id}/{matricula}")
    public void updateVehiculoById(@PathVariable int id, @PathVariable String matricula) {
        service.updateVehiculoById(id, matricula);
    }

    @PostMapping(value = "/vehiculo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable int id) {
        service.createVehiculo(vehiculo, id);
    }



}
