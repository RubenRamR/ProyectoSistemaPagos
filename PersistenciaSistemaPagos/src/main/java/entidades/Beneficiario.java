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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "beneficiarios")
public class Beneficiario implements Serializable {

    @Id
    @Column(name = "idBeneficiario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidoPaterno", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name = "usuario", length = 50, nullable = false)
    private String usuario;

    @Column(name = "contrasena", length = 100, nullable = false)
    private String contrasena;

    @Column(name = "claveContrato", length = 30, nullable = false)
    private String claveContrato;

    @Column(name = "saldo", nullable = false)
    private float saldo;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.PERSIST)
    private List<CuentaBancaria> cuentas;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.PERSIST)
    private List<Pago> pagos;

    public Beneficiario() {
        this.cuentas = new ArrayList<>();
        this.pagos = new ArrayList<>();
    }

    public Beneficiario(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.cuentas = new ArrayList<>();
        this.pagos = new ArrayList<>();
    }

    public Beneficiario(String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.cuentas = new ArrayList<>();
        this.pagos = new ArrayList<>();
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

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Beneficiario{");
        sb.append("id=").append(id);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", usuario=").append(usuario);
        sb.append(", contrasena=").append(contrasena);
        sb.append(", claveContrato=").append(claveContrato);
        sb.append(", saldo=").append(saldo);
        sb.append(", cuentas=").append(cuentas);
        sb.append(", pagos=").append(pagos);
        sb.append('}');
        return sb.toString();
    }

}
