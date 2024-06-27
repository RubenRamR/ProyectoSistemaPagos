/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;
import java.util.List;

/**
 * DTO (Data Transfer Object) que representa la información de un pago
 * realizado.
 */
public class PagoDTO {

    private Long id;
    private float monto;
    private String comprobante;
    private Calendar fechaHora;
    private BeneficiarioDTO beneficiario;
    private CuentaBancariaDTO cuentaBancaria;
    private TipoPagoDTO tipoPago;
    private List<AbonoDTO> abono;
    private List<Estatus_pagoDTO> estatusPagos;
    private boolean eliminado;

    /**
     * Constructor vacío de PagoDTO.
     */
    public PagoDTO() {
    }

    /**
     * Constructor de PagoDTO con parámetros.
     *
     * @param monto Monto del pago.
     * @param comprobante Número o identificador del comprobante asociado al
     * pago.
     * @param fechaHora Fecha y hora en que se realizó el pago.
     * @param beneficiario Beneficiario asociado al pago.
     * @param cuentaBancaria Cuenta bancaria asociada al pago.
     * @param tipoPago Tipo de pago realizado.
     */
    public PagoDTO(float monto, String comprobante, Calendar fechaHora, BeneficiarioDTO beneficiario,
            CuentaBancariaDTO cuentaBancaria, TipoPagoDTO tipoPago) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
    }

    /**
     * Constructor de PagoDTO con parámetros (sin cuenta bancaria).
     *
     * @param monto Monto del pago.
     * @param comprobante Número o identificador del comprobante asociado al
     * pago.
     * @param fechaHora Fecha y hora en que se realizó el pago.
     * @param beneficiario Beneficiario asociado al pago.
     * @param tipoPago Tipo de pago realizado.
     */
    public PagoDTO(float monto, String comprobante, Calendar fechaHora, BeneficiarioDTO beneficiario,
            TipoPagoDTO tipoPago) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.tipoPago = tipoPago;
    }

    /**
     * Constructor de PagoDTO con parámetros incluyendo el ID y listas
     * asociadas.
     *
     * @param id ID del pago.
     * @param monto Monto del pago.
     * @param comprobante Número o identificador del comprobante asociado al
     * pago.
     * @param fechaHora Fecha y hora en que se realizó el pago.
     * @param beneficiario Beneficiario asociado al pago.
     * @param cuentaBancaria Cuenta bancaria asociada al pago.
     * @param tipoPago Tipo de pago realizado.
     * @param abono Lista de abonos asociados al pago.
     * @param estatusPagos Lista de estados del pago.
     */
    public PagoDTO(Long id, float monto, String comprobante, Calendar fechaHora, BeneficiarioDTO beneficiario,
            CuentaBancariaDTO cuentaBancaria, TipoPagoDTO tipoPago, List<AbonoDTO> abono,
            List<Estatus_pagoDTO> estatusPagos) {
        this.id = id;
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
        this.abono = abono;
        this.estatusPagos = estatusPagos;
    }

    /**
     * Método para obtener el ID del pago.
     *
     * @return El ID del pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID del pago.
     *
     * @param id El ID del pago.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el monto del pago.
     *
     * @return El monto del pago.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Método para establecer el monto del pago.
     *
     * @param monto El monto del pago.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Método para obtener el número o identificador del comprobante asociado al
     * pago.
     *
     * @return El número o identificador del comprobante asociado al pago.
     */
    public String getComprobante() {
        return comprobante;
    }

    /**
     * Método para establecer el número o identificador del comprobante asociado
     * al pago.
     *
     * @param comprobante El número o identificador del comprobante asociado al
     * pago.
     */
    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    /**
     * Método para obtener la fecha y hora en que se realizó el pago.
     *
     * @return La fecha y hora en que se realizó el pago.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Método para establecer la fecha y hora en que se realizó el pago.
     *
     * @param fechaHora La fecha y hora en que se realizó el pago.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método para obtener el beneficiario asociado al pago.
     *
     * @return El beneficiario asociado al pago.
     */
    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método para establecer el beneficiario asociado al pago.
     *
     * @param beneficiario El beneficiario asociado al pago.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método para obtener la cuenta bancaria asociada al pago.
     *
     * @return La cuenta bancaria asociada al pago.
     */
    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Método para establecer la cuenta bancaria asociada al pago.
     *
     * @param cuentaBancaria La cuenta bancaria asociada al pago.
     */
    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Método para obtener el tipo de pago realizado.
     *
     * @return El tipo de pago realizado.
     */
    public TipoPagoDTO getTipoPago() {
        return tipoPago;
    }

    /**
     * Método para establecer el tipo de pago realizado.
     *
     * @param tipoPago El tipo de pago realizado.
     */
    public void setTipoPago(TipoPagoDTO tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * Método para obtener la lista de abonos asociados al pago.
     *
     * @return La lista de abonos asociados al pago.
     */
    public List<AbonoDTO> getAbono() {
        return abono;
    }

    /**
     * Método para establecer la lista de abonos asociados al pago.
     *
     * @param abono La lista de abonos asociados al pago.
     */
    public void setAbono(List<AbonoDTO> abono) {
        this.abono = abono;
    }

    /**
     * Método para obtener la lista de estados del pago.
     *
     * @return La lista de estados del pago.
     */
    public List<Estatus_pagoDTO> getEstatusPagos() {
        return estatusPagos;
    }

    /**
     * Método para establecer la lista de estados del pago.
     *
     * @param estatusPagos La lista de estados del pago.
     */
    public void setEstatusPagos(List<Estatus_pagoDTO> estatusPagos) {
        this.estatusPagos = estatusPagos;
    }

    /**
     * Método para verificar si el pago está marcado como eliminado.
     *
     * @return true si el pago está eliminado, false en caso contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /* Método para establecer el estado de eliminado del pago.
     *
     * @param eliminado true si el pago está eliminado, false en caso contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método toString que retorna una representación en cadena del objeto
     * PagoDTO.
     *
     * @return Representación en cadena del objeto PagoDTO.
     */
    @Override
    public String toString() {
        return "PagoDTO{"
                + "id=" + id
                + ", monto=" + monto
                + ", comprobante='" + comprobante + '\''
                + ", fechaHora=" + fechaHora
                + ", beneficiario=" + beneficiario
                + ", cuentaBancaria=" + cuentaBancaria
                + ", tipoPago=" + tipoPago
                + ", abono=" + abono
                + ", estatusPagos=" + estatusPagos
                + ", eliminado=" + eliminado
                + '}';
    }
}
