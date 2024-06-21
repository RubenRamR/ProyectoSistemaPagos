/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.PagoEntidad;
import java.util.Calendar;

/**
 *
 * @author rramirez
 */
public class AbonoDTO {

    private Long id;
    private Calendar fechaHora;
    private float monto;
    private PagoDTO pago;

    public AbonoDTO() {
    }

    public AbonoDTO(Calendar fechaHora, float monto, PagoDTO pago) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    public AbonoDTO(Long id, Calendar fechaHora, float monto, PagoDTO pago) {
        this.id = id;
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

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "AbonoDTO{" + "id=" + id + ", fechaHora=" + fechaHora + ", monto=" + monto + ", pago=" + pago + '}';
    }

}
