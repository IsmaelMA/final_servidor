package com.ismaelmaldonado.final_servidor.services.cliente;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

import java.util.List;

/**
 * Interfaz que define los servicios relacionados con la entidad Cliente.
 */
public interface IClienteService {

    /**
     * Obtiene una lista de todos los clientes.
     *
     * @return Lista de clientes.
     */
    public List<Cliente> listAllClients();

    /**
     * Obtiene una lista de todos los vehículos propiedad de un cliente específico.
     *
     * @param id Identificador único del cliente.
     * @return Lista de vehículos propiedad del cliente.
     */
    public List<Vehiculo> listAllVehiclesOwnedByClient(int id);

    /**
     * Obtiene un cliente en base a su identificador único.
     *
     * @param id Identificador único del cliente.
     * @return Cliente correspondiente al ID proporcionado.
     */
    public Cliente getClienteById(int id);

    /**
     * Elimina un cliente en base a su identificador único.
     *
     * @param id Identificador único del cliente a eliminar.
     */
    public void deleteClienteById(int id);

    /**
     * Actualiza la información de un cliente en base a su identificador único.
     *
     * @param id       Identificador único del cliente a actualizar.
     * @param nombre   Nuevo nombre para el cliente.
     * @param apellido Nuevo apellido para el cliente.
     */
    public void updateClienteById(int id, String nombre, String apellido);

    /**
     * Crea un nuevo cliente.
     *
     * @param cliente Objeto Cliente con la información para el nuevo cliente.
     */
    public void createClient(Cliente cliente);

    /**
     * Obtiene una lista de clientes en base a su apellido.
     *
     * @param apellido Apellido de los clientes a buscar.
     * @return Lista de clientes con el apellido especificado.
     */
    public List<Cliente> getClientesByApellido(String apellido);
}
