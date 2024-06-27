/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;

/**
 * DTO (Data Transfer Object) que representa el estado de un pago realizado.
 */
public class Estatus_pagoDTO {

    private Long id;
    private String mensaje;
    private Calendar fechaHora;
    private PagoDTO pago;
    private EstatusDTO estatus;

    /**
     * Constructor vacío de Estatus_pagoDTO.
     */
    public Estatus_pagoDTO() {
    }

    /**
     * Constructor de Estatus_pagoDTO con parámetros.
     *
     * @param mensaje Mensaje asociado al estado del pago.
     * @param fechaHora Fecha y hora en que se registró el estado.
     * @param pago Pago asociado al estado.
     * @param estatus Estado general del pago.
     */
    public Estatus_pagoDTO(String mensaje, Calendar fechaHora, PagoDTO pago, EstatusDTO estatus) {
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    /**
     * Constructor de Estatus_pagoDTO con parámetros incluyendo el ID.
     *
     * @param id ID del estado de pago.
     * @param mensaje Mensaje asociado al estado del pago.
     * @param fechaHora Fecha y hora en que se registró el estado.
     * @param pago Pago asociado al estado.
     * @param estatus Estado general del pago.
     */
    public Estatus_pagoDTO(Long id, String mensaje, Calendar fechaHora, PagoDTO pago, EstatusDTO estatus) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    /**
     * Método para obtener el ID del estado de pago.
     *
     * @return El ID del estado de pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID del estado de pago.
     *
     * @param id El ID del estado de pago.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el mensaje asociado al estado del pago.
     *
     * @return El mensaje asociado al estado del pago.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para establecer el mensaje asociado al estado del pago.
     *
     * @param mensaje El mensaje asociado al estado del pago.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Método para obtener la fecha y hora en que se registró el estado del
     * pago.
     *
     * @return La fecha y hora en que se registró el estado del pago.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Método para establecer la fecha y hora en que se registró el estado del
     * pago.
     *
     * @param fechaHora La fecha y hora en que se registró el estado del pago.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método para obtener el pago asociado al estado.
     *
     * @return El pago asociado al estado.
     */
    public PagoDTO getPago() {
        return pago;
    }

    /**
     * Método para establecer el pago asociado al estado.
     *
     * @param pago El pago asociado al estado.
     */
    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    /**
     * Método para obtener el estado general del pago.
     *
     * @return El estado general del pago.
     */
    public EstatusDTO getEstatus() {
        return estatus;
    }

    /**
     * Método para establecer el estado general del pago.
     *
     * @param estatus El estado general del pago.
     */
    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }

    /**
     * Retorna una representación en cadena del objeto Estatus_pagoDTO.
     *
     * @return Cadena que representa el objeto Estatus_pagoDTO.
     */
    @Override
    public String toString() {
        return "Estatus_pagoDTO{"
                + "id=" + id
                + ", mensaje='" + mensaje + '\''
                + ", fechaHora=" + fechaHora
                + ", pago=" + pago
                + ", estatus=" + estatus
                + '}';
    }
}
