package com.ismaelmaldonado.final_servidor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

/**
 * Representa una entidad Vehiculo en el sistema.
 * Esta entidad contiene detalles específicos de un vehículo y su relación con
 * un Cliente.
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    /**
     * Identificador único del Vehículo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Matrícula o número de placa del Vehículo.
     */
    private String matricula;

    /**
     * Fabricante o marca del Vehículo.
     */
    private String fabricante;

    /**
     * Modelo específico del Vehículo.
     */
    private String modelo;

    /**
     * Representa la relación con un Cliente.
     * Un vehículo puede pertenecer a un solo cliente.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Cliente cliente;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
    }

    /**
     * Constructor para crear un objeto Vehiculo solo con id.
     *
     * @param id Identificador único del Vehículo.
     */
    public Vehiculo(int id) {
        this.id = id;
    }

    /**
     * Proporciona el identificador del cliente asociado a este Vehículo.
     * 
     * @return Identificador del Cliente asociado o null si no hay Cliente asociado.
     */
    @JsonProperty("clienteId")
    @Transient
    public int getClienteId() {
        return (cliente != null) ? cliente.getId() : null;
    }

    /**
     * Obtiene el identificador del vehículo.
     *
     * @return Identificador del vehículo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del vehículo.
     *
     * @param id Nuevo identificador del vehículo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la matrícula del vehículo.
     *
     * @return Matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo.
     *
     * @param matricula Nueva matrícula del vehículo.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el fabricante del vehículo.
     *
     * @return Fabricante del vehículo.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Establece el fabricante del vehículo.
     *
     * @param fabricante Nuevo fabricante del vehículo.
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo Nuevo modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el cliente asociado al vehículo.
     *
     * @return Cliente asociado al vehículo.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al vehículo.
     *
     * @param cliente Nuevo cliente asociado al vehículo.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Constructor completo para crear un objeto Vehiculo.
     * 
     * @param id         Identificador único del Vehículo.
     * @param matricula  Matrícula del Vehículo.
     * @param fabricante Fabricante del Vehículo.
     * @param modelo     Modelo del Vehículo.
     * @param cliente    Cliente al que está asociado el Vehículo.
     */
    public Vehiculo(int id, String matricula, String fabricante, String modelo, Cliente cliente) {
        this.id = id;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public Vehiculo(String matricula, String fabricante, String modelo, Cliente cliente) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    /**
     * Calcula el código hash basado en el ID y la matrícula del vehículo.
     * 
     * @return Código hash del vehículo.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    /**
     * Compara este vehículo con otro objeto.
     *
     * @param obj Objeto a comparar.
     * @return verdadero si son iguales, falso en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (id != other.id)
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    /**
     * Retorna una representación en cadena del objeto Vehiculo.
     *
     * @return Representación en cadena del Vehiculo.
     */
    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", idCliente=" + cliente.getId() + ", fabricante=" + fabricante
                + ", modelo=" + modelo + "]";
    }
}
