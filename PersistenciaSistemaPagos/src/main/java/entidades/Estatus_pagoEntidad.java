/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "estatusPagos")
public class Estatus_pagoEntidad implements Serializable {

    @Id
    @Column(name = "idEstatusPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensaje")
    private String mensaje;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @ManyToOne(cascade
            = {
                CascadeType.PERSIST
            })
    @JoinColumn(name = "idPago", nullable = false)
    private PagoEntidad pago;

    @ManyToOne(cascade
            = {
                CascadeType.PERSIST
            })
    @JoinColumn(name = "idEstatus", nullable = false)
    private EstatusEntidad estatus;

    public Estatus_pagoEntidad() {
    }

    public Estatus_pagoEntidad(Long id, String mensaje, Calendar fechaHora, PagoEntidad pago, EstatusEntidad estatus) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    public Estatus_pagoEntidad(String mensaje, Calendar fechaHora, PagoEntidad pago, EstatusEntidad estatus) {
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public PagoEntidad getPago() {
        return pago;
    }

    public void setPago(PagoEntidad pago) {
        this.pago = pago;
    }

    public EstatusEntidad getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusEntidad estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Estatus_pagoEntidad{" + "id=" + id + ", mensaje=" + mensaje + ", fechaHora=" + fechaHora + ", pago=" + pago + ", estatus=" + estatus + '}';
    }

}
