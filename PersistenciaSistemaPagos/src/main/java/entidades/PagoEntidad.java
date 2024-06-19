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

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<AbonoEntidad> abono;

    @OneToMany(mappedBy = "pago", cascade = {CascadeType.PERSIST})
    private List<Estatus_pagoEntidad> estatusPagos;

    public PagoEntidad() {
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    public PagoEntidad(Long id, float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentasBancaria, TipoPagoEntidad tipoPago) {
        this.id = id;
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentasBancaria;
        this.tipoPago = tipoPago;
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    public PagoEntidad(float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentasBancaria, TipoPagoEntidad tipoPago) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentasBancaria;
        this.tipoPago = tipoPago;
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
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
        StringBuilder sb = new StringBuilder();
        sb.append("Pago{");
        sb.append("id=").append(id);
        sb.append(", monto=").append(monto);
        sb.append(", comprobante=").append(comprobante);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", beneficiario=").append(beneficiario);
        sb.append(", cuentasBancaria=").append(cuentaBancaria);
        sb.append(", tipoPago=").append(tipoPago);
        sb.append(", abono=").append(abono);
        sb.append(", Estatus_pago=").append(estatusPagos);
        sb.append('}');
        return sb.toString();
    }

}
