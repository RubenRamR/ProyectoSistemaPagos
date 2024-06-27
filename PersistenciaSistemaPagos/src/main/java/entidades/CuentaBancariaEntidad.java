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
 * Entidad que representa una cuenta bancaria asociada a un beneficiario en el
 * sistema.
 *
 * La entidad CuentaBancariaEntidad contiene información sobre el número de
 * cuenta, la clave de la cuenta, el banco asociado, el estado de eliminado y
 * las relaciones con el beneficiario y los pagos asociados.
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

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @ManyToOne
    @JoinColumn(name = "idBeneficiario", nullable = false)
    private BeneficiarioEntidad beneficiario;

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    /**
     * Constructor vacío de la clase CuentaBancariaEntidad.
     */
    public CuentaBancariaEntidad() {

    }

    /**
     * Constructor con parámetros de la clase CuentaBancariaEntidad.
     *
     * @param numeroCuenta Número de la cuenta bancaria.
     * @param clave Clave de la cuenta bancaria.
     * @param banco Nombre del banco asociado a la cuenta.
     * @param eliminado Estado de eliminación de la cuenta bancaria.
     * @param beneficiario Beneficiario asociado a la cuenta bancaria.
     */
    public CuentaBancariaEntidad(long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioEntidad beneficiario) {
        this.pagos = new ArrayList<>();
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
    }

    /**
     * Constructor con todos los parámetros de la clase CuentaBancariaEntidad.
     *
     * @param id Identificador único de la cuenta bancaria.
     * @param numeroCuenta Número de la cuenta bancaria.
     * @param clave Clave de la cuenta bancaria.
     * @param banco Nombre del banco asociado a la cuenta.
     * @param eliminado Estado de eliminación de la cuenta bancaria.
     * @param beneficiario Beneficiario asociado a la cuenta bancaria.
     * @param pagos Lista de pagos asociados a la cuenta bancaria.
     */
    public CuentaBancariaEntidad(Long id, long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = pagos;
    }

    /**
     * Constructor con todos los parámetros de la clase CuentaBancariaEntidad
     * excepto el id.
     *
     * @param numeroCuenta Número de la cuenta bancaria.
     * @param clave Clave de la cuenta bancaria.
     * @param banco Nombre del banco asociado a la cuenta.
     * @param eliminado Estado de eliminación de la cuenta bancaria.
     * @param beneficiario Beneficiario asociado a la cuenta bancaria.
     * @param pagos Lista de pagos asociados a la cuenta bancaria.
     */
    public CuentaBancariaEntidad(long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) {
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
        this.pagos = pagos;
    }

    /**
     * Método getter para obtener el id de la cuenta bancaria.
     *
     * @return El id de la cuenta bancaria.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el id de la cuenta bancaria.
     *
     * @param id El id de la cuenta bancaria a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el número de cuenta bancaria.
     *
     * @return El número de cuenta bancaria.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método setter para establecer el número de cuenta bancaria.
     *
     * @param numeroCuenta El número de cuenta bancaria a establecer.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método getter para obtener la clave de la cuenta bancaria.
     *
     * @return La clave de la cuenta bancaria.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método setter para establecer la clave de la cuenta bancaria.
     *
     * @param clave La clave de la cuenta bancaria a establecer.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método getter para obtener el nombre del banco asociado a la cuenta
     * bancaria.
     *
     * @return El nombre del banco asociado a la cuenta bancaria.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Método setter para establecer el nombre del banco asociado a la cuenta
     * bancaria.
     *
     * @param banco El nombre del banco a establecer.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Método getter para obtener el estado de eliminación de la cuenta
     * bancaria.
     *
     * @return true si la cuenta bancaria está marcada como eliminada, false en
     * caso contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para establecer el estado de eliminación de la cuenta
     * bancaria.
     *
     * @param eliminado El estado de eliminación a establecer.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método getter para obtener el beneficiario asociado a la cuenta bancaria.
     *
     * @return El beneficiario asociado a la cuenta bancaria.
     */
    public BeneficiarioEntidad getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método setter para establecer el beneficiario asociado a la cuenta
     * bancaria.
     *
     * @param beneficiario El beneficiario a establecer.
     */
    public void setBeneficiario(BeneficiarioEntidad beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método getter para obtener la lista de pagos asociados a la cuenta
     * bancaria.
     *
     * @return La lista de pagos asociados a la cuenta bancaria.
     */
    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    /**
     * Método setter para establecer la lista de pagos asociados a la cuenta
     * bancaria.
     *
     * @param pagos La lista de pagos a establecer.
     */
    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    /**
     * Override del método toString para imprimir los detalles de la cuenta
     * bancaria.
     *
     * @return Una representación en forma de cadena de la cuenta bancaria.
     */
    @Override
    public String toString() {
        return "CuentaBancariaEntidad{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", clave=" + clave + ", banco=" + banco + ", eliminado=" + eliminado + ", beneficiario=" + beneficiario + ", pagos=" + pagos + '}';
    }

}
