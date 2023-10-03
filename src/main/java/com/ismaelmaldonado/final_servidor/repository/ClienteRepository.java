package com.ismaelmaldonado.final_servidor.repository;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT v FROM Vehiculo v WHERE v.cliente.id = :id")
    public List<Vehiculo> getVehiculosByClienteId(@Param("id") int id);

    @Query("SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    public List<Cliente> getClientesByApellido(@Param("apellido") String apellido);

}
