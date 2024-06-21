/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author rramirez
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

    public PagoDTO() {
    }

    public PagoDTO(float monto, String comprobante, Calendar fechaHora, BeneficiarioDTO beneficiario, CuentaBancariaDTO cuentaBancaria, TipoPagoDTO tipoPago, List<AbonoDTO> abono, List<Estatus_pagoDTO> estatusPagos) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
        this.abono = abono;
        this.estatusPagos = estatusPagos;
    }

    public PagoDTO(Long id, float monto, String comprobante, Calendar fechaHora, BeneficiarioDTO beneficiario, CuentaBancariaDTO cuentaBancaria, TipoPagoDTO tipoPago, List<AbonoDTO> abono, List<Estatus_pagoDTO> estatusPagos) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public TipoPagoDTO getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoDTO tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<AbonoDTO> getAbono() {
        return abono;
    }

    public void setAbono(List<AbonoDTO> abono) {
        this.abono = abono;
    }

    public List<Estatus_pagoDTO> getEstatusPagos() {
        return estatusPagos;
    }

    public void setEstatusPagos(List<Estatus_pagoDTO> estatusPagos) {
        this.estatusPagos = estatusPagos;
    }

    @Override
    public String toString() {
        return "PagoDTO{" + "id=" + id + ", monto=" + monto + ", comprobante=" + comprobante + ", fechaHora=" + fechaHora + ", beneficiario=" + beneficiario + ", cuentaBancaria=" + cuentaBancaria + ", tipoPago=" + tipoPago + ", abono=" + abono + ", estatusPagos=" + estatusPagos + '}';
    }

}
