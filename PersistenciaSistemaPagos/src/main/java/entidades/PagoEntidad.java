/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "pagos")
public class PagoEntidad implements Serializable {

    @Id
    @Column(name = "idPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private float monto;

    @Column(name = "comprobante", nullable = false)
    private String comprobante;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @ManyToOne
    @JoinColumn(name = "idBeneficiario", nullable = false)
    private BeneficiarioEntidad beneficiario;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaBancariaEntidad cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "idTipoPago", nullable = false)
    private TipoPagoEntidad tipoPago;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<AbonoEntidad> abono;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<Estatus_pagoEntidad> estatusPagos;

    public PagoEntidad(float monto1, String comprobante1, Calendar fechaHora1) {
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    public PagoEntidad(Long id, float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentaBancaria, TipoPagoEntidad tipoPago, boolean eliminado, List<AbonoEntidad> abono, List<Estatus_pagoEntidad> estatusPagos) {
        this.id = id;
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
        this.eliminado = eliminado;
        this.abono = abono;
        this.estatusPagos = estatusPagos;
    }

    public PagoEntidad(float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentaBancaria, TipoPagoEntidad tipoPago, boolean eliminado, List<AbonoEntidad> abono, List<Estatus_pagoEntidad> estatusPagos) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
        this.eliminado = eliminado;
        this.abono = abono;
        this.estatusPagos = estatusPagos;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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

    public BeneficiarioEntidad getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioEntidad beneficiario) {
        this.beneficiario = beneficiario;
    }

    public CuentaBancariaEntidad getCuentasBancaria() {
        return cuentaBancaria;
    }

    public void setCuentasBancaria(CuentaBancariaEntidad cuentasBancaria) {
        this.cuentaBancaria = cuentasBancaria;
    }

    public TipoPagoEntidad getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoEntidad tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<AbonoEntidad> getAbono() {
        return abono;
    }

    public void setAbono(List<AbonoEntidad> abono) {
        this.abono = abono;
    }

    public List<Estatus_pagoEntidad> getEstatus_pago() {
        return estatusPagos;
    }

    public void setEstatus_pago(List<Estatus_pagoEntidad> Estatus_pago) {
        this.estatusPagos = Estatus_pago;
    }

    @Override
    public String toString() {
        return "PagoEntidad{" + "id=" + id + ", monto=" + monto + ", comprobante=" + comprobante + ", fechaHora=" + fechaHora + ", beneficiario=" + beneficiario + ", cuentaBancaria=" + cuentaBancaria + ", tipoPago=" + tipoPago + ", abono=" + abono + ", estatusPagos=" + estatusPagos + '}';
    }

}
