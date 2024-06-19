/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "cuentasBancarias")
public class CuentaBancariaEntidad implements Serializable {

    @Id
    @Column(name = "idCuenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroCuenta", nullable = false)
    private long numeroCuenta;

    @Column(name = "clave", length = 100, nullable = false)
    private String clave;

    @Column(name = "banco", length = 50, nullable = false)
    private String banco;

    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    @ManyToOne
    @JoinColumn(name = "idBeneficiario", nullable = false)
    private BeneficiarioEntidad beneficiario;

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    public CuentaBancariaEntidad(long par, String clave123, String banco_XYZ, boolean par1, BeneficiarioEntidad beneficiario1) {
        this.pagos = new ArrayList<>();
    }

    public CuentaBancariaEntidad(Long id, long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioEntidad beneficiario) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = new ArrayList<>();
    }

    public CuentaBancariaEntidad(long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) {
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = pagos;
        this.pagos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public BeneficiarioEntidad getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioEntidad beneficiario) {
        this.beneficiario = beneficiario;
    }

    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaBancaria{");
        sb.append("id=").append(id);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", clave=").append(clave);
        sb.append(", banco=").append(banco);
        sb.append(", eliminado=").append(eliminado);
        sb.append(", beneficiario=").append(beneficiario);
        sb.append(", pagos=").append(pagos);
        sb.append('}');
        return sb.toString();
    }

}
