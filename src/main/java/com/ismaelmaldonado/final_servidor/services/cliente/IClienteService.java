package com.ismaelmaldonado.final_servidor.services.cliente;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listAllClients();

    public List<Vehiculo> listAllVehiclesOwnedByClient(int id);

    public Cliente getClienteById(int id);

    public void deleteClienteById(int id);

    public void updateClienteById(int id, String nombre, String apellido);

    public void createClient(Cliente cliente);

    public List<Cliente> getClientesByApellido(String apellido);
}
