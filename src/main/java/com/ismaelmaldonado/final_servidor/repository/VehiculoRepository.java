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
 * entidad Vehiculo.
 * Extiende de JpaRepository para aprovechar las operaciones CRUD básicas.
 */
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    /**
     * Consulta personalizada para obtener todos los vehículos que tienen un
     * fabricante específico.
     *
     * @param nombreFabricante Nombre del fabricante del vehículo.
     * @return Lista de vehículos con el fabricante especificado.
     */
    @Query("SELECT v FROM Vehiculo v WHERE v.fabricante = :nombreFabricante")
    public List<Vehiculo> getVehiculosByFabricante(@Param("nombreFabricante") String nombreFabricante);

    /**
     * Consulta personalizada para obtener un vehículo en base a su matrícula.
     *
     * @param matricula Matrícula del vehículo.
     * @return Vehículo con la matrícula especificada.
     */
    @Query("SELECT v FROM Vehiculo v WHERE v.matricula = :matricula")
    public Vehiculo getVehiculoByMatricula(@Param("matricula") String matricula);

    /**
     * Consulta personalizada para obtener el cliente asociado a un vehículo
     * específico por ID.
     *
     * @param id Identificador único del vehículo.
     * @return Cliente asociado al vehículo especificado.
     */
    @Query("SELECT c FROM Cliente c JOIN c.vehiculos v WHERE v.id = :id")
    public Cliente getClienteByVehiculoID(@Param("id") int id);

}
