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
@Table (name = "estatusPagos")
public class Estatus_pago implements Serializable {

    @Id
    @Column(name = "idEstatusPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensaje")
    private String mensaje;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idPago", nullable = false)
    private Pago pago;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idEstatus", nullable = false)
    private Estatus estatus;

    public Estatus_pago() {
    }

    public Estatus_pago(Long id, String mensaje, Calendar fechaHora, Pago pago, Estatus estatus) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    public Estatus_pago(String mensaje, Calendar fechaHora, Pago pago, Estatus estatus) {
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

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estatus_pago{");
        sb.append("id=").append(id);
        sb.append(", mensaje=").append(mensaje);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", pago=").append(pago);
        sb.append(", estatus=").append(estatus);
        sb.append('}');
        return sb.toString();
    }

}
