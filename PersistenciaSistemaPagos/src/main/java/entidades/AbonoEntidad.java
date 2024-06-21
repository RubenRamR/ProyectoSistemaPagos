/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "abonos")
public class AbonoEntidad implements Serializable {

    @Id
    @Column(name = "idAbono")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "idPago", nullable = false)
    private PagoEntidad pago;

    public AbonoEntidad() {
    }

    public AbonoEntidad(Long id, Calendar fechaHora, float monto, PagoEntidad pago) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    public AbonoEntidad(Calendar fechaHora, float monto, PagoEntidad pago) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public PagoEntidad getPago() {
        return pago;
    }

    public void setPago(PagoEntidad pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AbonoEntidad{");
        sb.append("id=").append(id);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", monto=").append(monto);
        sb.append(", pago=").append(pago);
        sb.append('}');
        return sb.toString();
    }

}
