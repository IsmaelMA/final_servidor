package com.ismaelmaldonado.final_servidor.services.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.repository.ClienteRepository;

/**
 * Implementación del servicio relacionado con la entidad Cliente.
 */
@Service
public class ClienteService implements IClienteService {

    // Repositorio para gestionar las operaciones de persistencia relacionadas con
    // clientes.
    @Autowired
    private ClienteRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cliente> listAllClients() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehiculo> listAllVehiclesOwnedByClient(int id) {
        return repository.getVehiculosByClienteId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cliente getClienteById(int id) {
        return repository.findById(id).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteClienteById(int id) {
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateClienteById(int id, String nombre, String apellido) {
        Cliente cliente = repository.findById(id).get();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        repository.save(cliente);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createClient(Cliente cliente) {
        repository.save(cliente);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cliente> getClientesByApellido(String apellido) {
        return repository.getClientesByApellido(apellido);
    }
}
