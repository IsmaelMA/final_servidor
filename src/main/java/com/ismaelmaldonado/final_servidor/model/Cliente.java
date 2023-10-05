package com.ismaelmaldonado.final_servidor.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Representa una entidad Cliente en el sistema.
 * Esta entidad contiene detalles personales de un cliente y una lista de
 * vehículos asociados.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    /**
     * Identificador único del Cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Nombre del Cliente.
     */
    private String nombre;

    /**
     * Apellido del Cliente.
     */
    private String apellido;

    /**
     * Representa una lista de Vehículos asociados a este Cliente.
     * Esta relación es administrada por una asociación de uno a muchos, donde un
     * cliente puede tener varios vehículos.
     */
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Vehiculo> vehiculos;

    /**
     * Constructor por defecto.
     */
    public Cliente() {
    }

    /**
     * Constructor para crear un objeto Cliente solo con id.
     * 
     * @param id Identificador único del Cliente.
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Constructor para crear un objeto Cliente completamente poblado.
     *
     * @param id        Identificador único del Cliente.
     * @param nombre    Nombre del Cliente.
     * @param apellido  Apellido del Cliente.
     * @param vehiculos Lista de Vehículos asociados a este Cliente.
     */
    public Cliente(int id, String nombre, String apellido, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * @return Identificador único del Cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del Cliente.
     *
     * @param id Identificador a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Nombre del Cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del Cliente.
     *
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Apellido del Cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del Cliente.
     *
     * @param apellido Apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return Lista de Vehículos asociados al Cliente.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de Vehículos asociados al Cliente.
     *
     * @param vehiculos Lista de vehículos a establecer.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Redefinición del método equals para comparar objetos Cliente por su
     * identificador.
     *
     * @param o Objeto a comparar.
     * @return Verdadero si los objetos son iguales, falso en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    /**
     * @return Código hash del Cliente, basado en su identificador.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @return Representación en cadena del objeto Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
