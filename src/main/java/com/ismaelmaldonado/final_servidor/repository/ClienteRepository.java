package com.ismaelmaldonado.final_servidor.repository;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones de base de datos relacionadas con la
 * entidad Cliente.
 * Extiende de JpaRepository para aprovechar las operaciones CRUD básicas.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Consulta personalizada para obtener todos los vehículos asociados a un
     * cliente específico por ID.
     *
     * @param id Identificador único del cliente.
     * @return Lista de vehículos asociados al cliente.
     */
    @Query("SELECT v FROM Vehiculo v WHERE v.cliente.id = :id")
    public List<Vehiculo> getVehiculosByClienteId(@Param("id") int id);

    /**
     * Consulta personalizada para obtener todos los clientes que tienen un apellido
     * específico.
     *
     * @param apellido Apellido del cliente.
     * @return Lista de clientes con el apellido especificado.
     */
    @Query("SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    public List<Cliente> getClientesByApellido(@Param("apellido") String apellido);

}
