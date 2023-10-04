package com.ismaelmaldonado.final_servidor.repository;

import com.ismaelmaldonado.final_servidor.model.Cliente;
import com.ismaelmaldonado.final_servidor.model.Vehiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT v FROM Vehiculo v WHERE v.fabricante = :nombreFabricante")
    public List<Vehiculo> getVehiculosByFabricante(@Param("nombreFabricante") String nombreFabricante);

    @Query("SELECT v FROM Vehiculo v WHERE v.matricula = :matricula")
    public Vehiculo getVehiculoByMatricula(@Param("matricula") String matricula);

    @Query("SELECT c FROM Cliente c JOIN c.vehiculos v WHERE v.id = :id")
    public Cliente getClienteByVehiculoID(@Param("id") int id);

}
