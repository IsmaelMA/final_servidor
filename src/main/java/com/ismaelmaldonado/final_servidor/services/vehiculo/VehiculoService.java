package com.ismaelmaldonado.final_servidor.services.vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.repository.ClienteRepository;
import com.ismaelmaldonado.final_servidor.repository.VehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    private VehiculoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Vehiculo> listAllVehicles() {
        return repository.findAll();
    }

    @Override
    public Vehiculo getVehiculoById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Vehiculo getVehiculoByMatricula(String matricula) {
        return repository.getVehiculoByMatricula(matricula);
    }

    @Override
    public void deleteVehiculoById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateVehiculoById(int id, String matricula) {
        Vehiculo vehiculo = repository.findById(id).get();
        vehiculo.setMatricula(matricula);
        repository.save(vehiculo);
    }

    @Override
    public void createVehiculo(Vehiculo vehiculo, int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        vehiculo.setCliente(cliente);

        repository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante) {
        return repository.getVehiculosByFabricante(nombreFabricante);
    }

    @Override
    public Cliente getClienteByVehiculoId(int id) {
        return repository.getClienteByVehiculoID(id);
    }

}
