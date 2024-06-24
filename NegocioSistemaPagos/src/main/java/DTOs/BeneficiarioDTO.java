/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

public class BeneficiarioDTO {

    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String contrasena;
    private String claveContrato;
    private float saldo;
    private List<CuentaBancariaDTO> cuentas;
    private List<PagoDTO> pagos;
    private boolean eliminado;

    public BeneficiarioDTO() {
    }

    public BeneficiarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.cuentas = cuentas;
        this.pagos = pagos;
    }

    public BeneficiarioDTO(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.cuentas = cuentas;
        this.pagos = pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getClaveContrato() {
        return claveContrato;
    }

    public void setClaveContrato(String claveContrato) {
        this.claveContrato = claveContrato;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<CuentaBancariaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaBancariaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    public List<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "BeneficiarioDTO{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", claveContrato='" + claveContrato + '\'' +
                ", saldo=" + saldo +
                ", cuentas=" + cuentas +
                ", pagos=" + pagos +
                ", eliminado=" + eliminado +
                '}';
    }
}
