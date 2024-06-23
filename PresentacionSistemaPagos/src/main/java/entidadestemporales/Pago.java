/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadestemporales;

/**
 *
 * @author crazy
 */
public class Pago {
    String id;
    String monto;
    String FechaHora;
    String estatus;
    String tipo;
    String beneficiario;
    String cuenta;
    String terminado;
    String parcialidades;

    public Pago(String id, String monto, String FechaHora, String estatus, String tipo, String beneficiario, String cuenta, String terminado, String parcialidades) {
        this.id = id;
        this.monto = monto;
        this.FechaHora = FechaHora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.beneficiario = beneficiario;
        this.cuenta = cuenta;
        this.terminado = terminado;
        this.parcialidades = parcialidades;
    }

    public Pago() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTerminado() {
        return terminado;
    }

    public void setTerminado(String terminado) {
        this.terminado = terminado;
    }

    public String getParcialidades() {
        return parcialidades;
    }

    public void setParcialidades(String parcialidades) {
        this.parcialidades = parcialidades;
    }
    
    
}
