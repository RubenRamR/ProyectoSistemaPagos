/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadestemporales;

/**
 *
 * @author crazy
 */
public class Cuenta {
    String id;
    String numeroCuenta;
    String clave;
    String banco;

    public Cuenta() {
    }

    public Cuenta(String id, String numeroCuenta, String clave, String banco) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
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
    
    
}
