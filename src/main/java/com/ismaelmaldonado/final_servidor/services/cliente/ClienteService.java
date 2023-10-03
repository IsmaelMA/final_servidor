package com.ismaelmaldonado.final_servidor.services.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listAllClients() {
        return repository.findAll();
    }

    @Override
    public List<Vehiculo> listAllVehiclesOwnedByClient(int id) {
        return repository.getVehiculosByClienteId(id);
    }

    @Override
    public Cliente getClienteById(int id) {
        return repository.findById(id).get();

    }

    @Override
    public void deleteClienteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void updateClienteById(int id, String nombre, String apellido) {
        Cliente cliente = repository.findById(id).get();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        repository.save(cliente);

    }

    @Override
    public void createClient(Cliente cliente) {
        repository.save(cliente);

    }

    @Override
    public List<Cliente> getClientesByApellido(String apellido) {
        return repository.getClientesByApellido(apellido);
    }

}
