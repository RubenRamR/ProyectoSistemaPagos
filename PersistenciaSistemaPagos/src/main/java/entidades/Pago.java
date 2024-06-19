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
public class Pago implements Serializable {

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
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaBancaria cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "idTipoPago", nullable = false)
    private TipoPago tipoPago;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<Abono> abono;

    @OneToMany(mappedBy = "pago", cascade = {CascadeType.PERSIST})
    private List<Estatus_pago> estatusPagos;

    public Pago() {
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    public Pago(Long id, float monto, String comprobante, Calendar fechaHora, Beneficiario beneficiario, CuentaBancaria cuentasBancaria, TipoPago tipoPago) {
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

    public Pago(float monto, String comprobante, Calendar fechaHora, Beneficiario beneficiario, CuentaBancaria cuentasBancaria, TipoPago tipoPago) {
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

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public CuentaBancaria getCuentasBancaria() {
        return cuentaBancaria;
    }

    public void setCuentasBancaria(CuentaBancaria cuentasBancaria) {
        this.cuentaBancaria = cuentasBancaria;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<Abono> getAbono() {
        return abono;
    }

    public void setAbono(List<Abono> abono) {
        this.abono = abono;
    }

    public List<Estatus_pago> getEstatus_pago() {
        return estatusPagos;
    }

    public void setEstatus_pago(List<Estatus_pago> Estatus_pago) {
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
