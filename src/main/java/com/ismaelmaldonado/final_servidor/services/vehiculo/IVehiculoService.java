package com.ismaelmaldonado.final_servidor.services.vehiculo;

import java.util.List;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

/**
 * Interfaz que define los servicios relacionados con la entidad Vehiculo.
 */
public interface IVehiculoService {

    /**
     * Lista todos los vehículos disponibles.
     * 
     * @return Lista de vehículos.
     */
    public List<Vehiculo> listAllVehicles();

    /**
     * Recupera un vehículo por su identificador.
     * 
     * @param id Identificador del vehículo.
     * @return Vehículo correspondiente al identificador dado.
     */
    public Vehiculo getVehiculoById(int id);

    /**
     * Recupera un vehículo por su matrícula.
     * 
     * @param matricula Matrícula del vehículo.
     * @return Vehículo correspondiente a la matrícula dada.
     */
    public Vehiculo getVehiculoByMatricula(String matricula);

    /**
     * Elimina un vehículo basado en su identificador.
     * 
     * @param id Identificador del vehículo a eliminar.
     */
    public void deleteVehiculoById(int id);

    /**
     * Actualiza la matrícula de un vehículo específico.
     * 
     * @param id        Identificador del vehículo a actualizar.
     * @param matricula Nueva matrícula para el vehículo.
     */
    public void updateVehiculoById(int id, String matricula);

    /**
     * Crea un nuevo vehículo y lo asocia a un cliente específico.
     * 
     * @param vehiculo  Vehículo a crear.
     * @param idCliente Identificador del cliente al que se asocia el vehículo.
     */
    public void createVehiculo(Vehiculo vehiculo, int idCliente);

    /**
     * Lista todos los vehículos de un fabricante específico.
     * 
     * @param nombreFabricante Nombre del fabricante.
     * @return Lista de vehículos del fabricante dado.
     */
    public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante);

    /**
     * Recupera el cliente asociado a un vehículo específico.
     * 
     * @param id Identificador del vehículo.
     * @return Cliente asociado al vehículo dado.
     */
    public Cliente getClienteByVehiculoId(int id);

}
