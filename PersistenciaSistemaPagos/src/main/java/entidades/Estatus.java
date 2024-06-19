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
 *
 * @author Chris
 */
@Entity
@Table (name = "estatus")
public class Estatus implements Serializable {

    @Id
    @Column(name = "idEstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estatus", cascade = {CascadeType.PERSIST})
    private List<Estatus_pago> estatusPagos;

    public Estatus() {
        this.estatusPagos = new ArrayList<>();
    }

    public Estatus(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estatusPagos = new ArrayList<>();
    }

    public Estatus(String nombre) {
        this.nombre = nombre;
        this.estatusPagos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estatus_pago> getEstatus_pago() {
        return estatusPagos;
    }

    public void setEstatus_pago(List<Estatus_pago> Estatus_pago) {
        this.estatusPagos = Estatus_pago;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estatus{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", Estatus_pago=").append(estatusPagos);
        sb.append('}');
        return sb.toString();
    }

}