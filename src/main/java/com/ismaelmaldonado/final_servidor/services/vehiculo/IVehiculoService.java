package com.ismaelmaldonado.final_servidor.services.vehiculo;

import java.util.List;

import com.ismaelmaldonado.final_servidor.model.Vehiculo;

public interface IVehiculoService {

    public List<Vehiculo> listAllVehicles();

    public Vehiculo getVehiculoById(int id);

    public Vehiculo getVehiculoByMatricula(String matricula);

    public void deleteVehiculoById(int id);

    public void updateVehiculoById(int id, String matricula);

    public void createVehiculo(Vehiculo vehiculo, int idCliente);

    public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante);

}
