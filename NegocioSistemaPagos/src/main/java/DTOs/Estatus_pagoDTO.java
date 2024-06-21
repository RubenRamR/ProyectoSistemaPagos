/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;

/**
 *
 * @author rramirez
 */
public class Estatus_pagoDTO {

    private Long id;
    private String mensaje;
    private Calendar fechaHora;
    private PagoDTO pago;
    private EstatusDTO estatus;

    public Estatus_pagoDTO() {
    }

    public Estatus_pagoDTO(String mensaje, Calendar fechaHora, PagoDTO pago, EstatusDTO estatus) {
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    public Estatus_pagoDTO(Long id, String mensaje, Calendar fechaHora, PagoDTO pago, EstatusDTO estatus) {
        this.id = id;
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

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Estatus_pagoDTO{" + "id=" + id + ", mensaje=" + mensaje + ", fechaHora=" + fechaHora + ", pago=" + pago + ", estatus=" + estatus + '}';
    }

}
