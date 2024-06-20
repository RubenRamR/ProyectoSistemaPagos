/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 *
 * @author rramirez
 */
public class CuentaBancariaDTO {

    private Long id;
    private long numeroCuenta;
    private String clave;
    private String banco;
    private boolean eliminado;
    private BeneficiarioDTO beneficiario;
    private List<PagoDTO> pagos;

    public CuentaBancariaDTO() {
    }

    public CuentaBancariaDTO(long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) {
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = pagos;
    }

    public CuentaBancariaDTO(Long id, long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = pagos;
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

    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public List<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        return "CuentaBancariaDTO{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", clave=" + clave + ", banco=" + banco + ", eliminado=" + eliminado + ", beneficiario=" + beneficiario + ", pagos=" + pagos + '}';
    }

}
