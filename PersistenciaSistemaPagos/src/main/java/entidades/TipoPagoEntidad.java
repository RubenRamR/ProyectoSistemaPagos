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

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    public TipoPagoEntidad(String nombre, int numMensualidades, boolean eliminado, List<PagoEntidad> pagos) {
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.eliminado = eliminado;
        this.pagos = pagos;
    }

    public TipoPagoEntidad() {
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

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    public TipoPagoEntidad(Long id, String nombre, int numMensualidades, boolean eliminado, List<PagoEntidad> pagos) {
        this.id = id;
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.eliminado = eliminado;
        this.pagos = pagos;
    }
}
   