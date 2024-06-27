/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;

/**
 * DTO (Data Transfer Object) que representa un abono realizado a un pago. Se
 * utiliza para transferir datos relacionados con abonos entre diferentes capas
 * del sistema.
 */
public class AbonoDTO {

    private Long id;
    private Calendar fechaHora;
    private float monto;
    private PagoDTO pago;
    private boolean eliminado;

    /**
     * Constructor por defecto de AbonoDTO.
     */
    public AbonoDTO() {
    }

    /**
     * Constructor de AbonoDTO con parámetros.
     *
     * @param fechaHora Fecha y hora del abono.
     * @param monto Monto del abono.
     * @param pago Pago asociado al abono.
     */
    public AbonoDTO(Calendar fechaHora, float monto, PagoDTO pago) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    /**
     * Constructor de AbonoDTO con todos los atributos.
     *
     * @param id ID único del abono.
     * @param fechaHora Fecha y hora del abono.
     * @param monto Monto del abono.
     * @param pago Pago asociado al abono.
     */
    public AbonoDTO(Long id, Calendar fechaHora, float monto, PagoDTO pago) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    /**
     * Obtiene el ID del abono.
     *
     * @return ID del abono.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del abono.
     *
     * @param id ID del abono a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora del abono.
     *
     * @return Fecha y hora del abono.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del abono.
     *
     * @param fechaHora Fecha y hora del abono a establecer.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el monto del abono.
     *
     * @return Monto del abono.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto del abono.
     *
     * @param monto Monto del abono a establecer.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el DTO del pago asociado al abono.
     *
     * @return DTO del pago asociado al abono.
     */
    public PagoDTO getPago() {
        return pago;
    }

    /**
     * Establece el DTO del pago asociado al abono.
     *
     * @param pago DTO del pago a establecer.
     */
    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    /**
     * Verifica si el abono ha sido marcado como eliminado.
     *
     * @return true si el abono está marcado como eliminado, false de lo
     * contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación del abono.
     *
     * @param eliminado true para marcar el abono como eliminado, false de lo
     * contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Retorna una representación en cadena del objeto AbonoDTO.
     *
     * @return Cadena que representa el objeto AbonoDTO.
     */
    @Override
    public String toString() {
        return "AbonoDTO{"
                + "id=" + id
                + ", fechaHora=" + fechaHora
                + ", monto=" + monto
                + ", pago=" + pago
                + ", eliminado=" + eliminado
                + '}';
    }
}
