package com.ismaelmaldonado.final_servidor.services.vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;
import com.ismaelmaldonado.final_servidor.repository.ClienteRepository;
import com.ismaelmaldonado.final_servidor.repository.VehiculoRepository;

/**
 * Servicio que implementa las operaciones relacionadas con la entidad Vehiculo.
 */
@Service
public class VehiculoService implements IVehiculoService {

    // Inyección de dependencia para el repositorio de vehículos.
    @Autowired
    private VehiculoRepository repository;

    // Inyección de dependencia para el repositorio de clientes.
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Recupera la lista de todos los vehículos.
     * 
     * @return Lista de vehículos.
     */
    @Override
    public List<Vehiculo> listAllVehicles() {
        return repository.findAll();
    }

    /**
     * Obtiene un vehículo específico por su ID.
     * 
     * @param id ID del vehículo.
     * @return Vehículo buscado.
     */
    @Override
    public Vehiculo getVehiculoById(int id) {
        return repository.findById(id).get();
    }

    /**
     * Obtiene un vehículo por su matrícula.
     * 
     * @param matricula Matrícula del vehículo.
     * @return Vehículo buscado.
     */
    @Override
    public Vehiculo getVehiculoByMatricula(String matricula) {
        return repository.getVehiculoByMatricula(matricula);
    }

    /**
     * Elimina un vehículo por su ID.
     * 
     * @param id ID del vehículo a eliminar.
     */
    @Override
    public void deleteVehiculoById(int id) {
        repository.deleteById(id);
    }

    /**
     * Actualiza la matrícula de un vehículo por su ID.
     * 
     * @param id        ID del vehículo a actualizar.
     * @param matricula Nueva matrícula para el vehículo.
     */
    @Override
    public void updateVehiculoById(int id, String matricula) {
        Vehiculo vehiculo = repository.findById(id).get();
        vehiculo.setMatricula(matricula);
        repository.save(vehiculo);
    }

    /**
     * Crea un vehículo y lo asocia a un cliente específico.
     * 
     * @param vehiculo  Vehículo a crear.
     * @param idCliente ID del cliente al que se asocia el vehículo.
     */
    @Override
    public void createVehiculo(Vehiculo vehiculo, int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        vehiculo.setCliente(cliente);
        repository.save(vehiculo);
    }

    /**
     * Recupera la lista de vehículos por un fabricante específico.
     * 
     * @param nombreFabricante Nombre del fabricante de vehículos.
     * @return Lista de vehículos del fabricante especificado.
     */
    @Override
    public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante) {
        return repository.getVehiculosByFabricante(nombreFabricante);
    }

    /**
     * Obtiene el cliente asociado a un vehículo específico.
     * 
     * @param id ID del vehículo.
     * @return Cliente asociado al vehículo.
     */
    @Override
    public Cliente getClienteByVehiculoId(int id) {
        return repository.getClienteByVehiculoID(id);
    }
}
