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
@Table(name = "tiposPagos")
public class TipoPagoEntidad implements Serializable {

    @Id
    @Column(name = "idTipoPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "numMensualidades", nullable = false)
    private int numMensualidades;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    public TipoPagoEntidad() {
        this.pagos = new ArrayList<>();
    }

    public TipoPagoEntidad(Long id, String nombre, int numMensualidades) {
        this.id = id;
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.pagos = new ArrayList<>();
    }

    public TipoPagoEntidad(String nombre, int numMensualidades) {
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.pagos = new ArrayList<>();
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

    public int getNumMensualidades() {
        return numMensualidades;
    }

    public void setNumMensualidades(int numMensualidades) {
        this.numMensualidades = numMensualidades;
    }

    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoPago{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", numMensualidades=").append(numMensualidades);
        sb.append(", pagos=").append(pagos);
        sb.append('}');
        return sb.toString();
    }

}
