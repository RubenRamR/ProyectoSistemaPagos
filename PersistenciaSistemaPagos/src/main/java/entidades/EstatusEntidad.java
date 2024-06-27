/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad que representa un estado o estatus en el sistema.
 *
 * La entidad EstatusEntidad contiene información sobre el nombre del estatus,
 * el estado de eliminado y las relaciones con los pagos asociados a este
 * estatus.
 */
@Entity
@Table(name = "estatus")
public class EstatusEntidad implements Serializable {

    @Id
    @Column(name = "idEstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "estatus", cascade = CascadeType.PERSIST)
    private List<Estatus_pagoEntidad> estatusPagos;

    /**
     * Constructor vacío de la clase EstatusEntidad.
     */
    public EstatusEntidad() {
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros de la clase EstatusEntidad.
     *
     * @param id Identificador único del estatus.
     * @param nombre Nombre del estatus.
     */
    public EstatusEntidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Constructor con parámetro de nombre de la clase EstatusEntidad.
     *
     * @param nombre Nombre del estatus.
     */
    public EstatusEntidad(String nombre) {
        this.nombre = nombre;
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Método getter para obtener el id del estatus.
     *
     * @return El id del estatus.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el id del estatus.
     *
     * @param id El id del estatus a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del estatus.
     *
     * @return El nombre del estatus.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del estatus.
     *
     * @param nombre El nombre del estatus a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el estado de eliminación del estatus.
     *
     * @return true si el estatus está marcado como eliminado, false en caso
     * contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para establecer el estado de eliminación del estatus.
     *
     * @param eliminado El estado de eliminación a establecer.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método getter para obtener la lista de pagos asociados al estatus.
     *
     * @return La lista de pagos asociados al estatus.
     */
    public List<Estatus_pagoEntidad> getEstatusPagos() {
        return estatusPagos;
    }

    /**
     * Método setter para establecer la lista de pagos asociados al estatus.
     *
     * @param estatusPagos La lista de pagos a establecer.
     */
    public void setEstatusPagos(List<Estatus_pagoEntidad> estatusPagos) {
        this.estatusPagos = estatusPagos;
    }

    /**
     * Override del método toString para imprimir los detalles del estatus.
     *
     * @return Una representación en forma de cadena del estatus.
     */
    @Override
    public String toString() {
        return "EstatusEntidad{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", eliminado=" + eliminado
                + ", estatusPagos=" + estatusPagos
                + '}';
    }
}
