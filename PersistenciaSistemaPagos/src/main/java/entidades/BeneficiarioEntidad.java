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
 * Clase entidad que representa un beneficiario en el sistema.
 *
 * <p>
 * Esta entidad está mapeada a la tabla "beneficiarios" en la base de datos.</p>
 */
@Entity
@Table(name = "beneficiarios")
public class BeneficiarioEntidad implements Serializable {

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

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.PERSIST)
    private List<CuentaBancariaEntidad> cuentas;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    /**
     * Constructor vacío de la clase BeneficiarioEntidad.
     */
    public BeneficiarioEntidad(){
        
    }

    /**
     * Constructor con todos los atributos de la clase BeneficiarioEntidad.
     *
     * @param nombres Nombres del beneficiario.
     * @param apellidoPaterno Apellido paterno del beneficiario.
     * @param apellidoMaterno Apellido materno del beneficiario.
     * @param usuario Usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @param claveContrato Clave de contrato del beneficiario.
     * @param saldo Saldo del beneficiario.
     */
    public BeneficiarioEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo) {
        this.cuentas = new ArrayList<>();
        this.pagos = new ArrayList<>();

        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
    }

    /**
     * Constructor con todos los atributos, incluyendo el ID, de la clase
     * BeneficiarioEntidad.
     *
     * @param id ID del beneficiario.
     * @param nombres Nombres del beneficiario.
     * @param apellidoPaterno Apellido paterno del beneficiario.
     * @param apellidoMaterno Apellido materno del beneficiario.
     * @param usuario Usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @param claveContrato Clave de contrato del beneficiario.
     * @param saldo Saldo del beneficiario.
     * @param eliminado Estado de eliminación del beneficiario.
     * @param cuentas Lista de cuentas bancarias asociadas al beneficiario.
     * @param pagos Lista de pagos realizados por el beneficiario.
     */
    public BeneficiarioEntidad(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo, boolean eliminado, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.eliminado = eliminado;
        this.cuentas = cuentas;
        this.pagos = pagos;
    }

    /**
     * Constructor sin el ID del beneficiario.
     *
     * @param nombres Nombres del beneficiario.
     * @param apellidoPaterno Apellido paterno del beneficiario.
     * @param apellidoMaterno Apellido materno del beneficiario.
     * @param usuario Usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @param claveContrato Clave de contrato del beneficiario.
     * @param saldo Saldo del beneficiario.
     * @param eliminado Estado de eliminación del beneficiario.
     * @param cuentas Lista de cuentas bancarias asociadas al beneficiario.
     * @param pagos Lista de pagos realizados por el beneficiario.
     */
    public BeneficiarioEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String claveContrato, float saldo, boolean eliminado, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claveContrato = claveContrato;
        this.saldo = saldo;
        this.eliminado = eliminado;
        this.cuentas = cuentas;
        this.pagos = pagos;
    }

    /**
     * Obtiene el ID del beneficiario.
     *
     * @return El ID del beneficiario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del beneficiario.
     *
     * @param id El ID del beneficiario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del beneficiario.
     *
     * @return Los nombres del beneficiario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del beneficiario.
     *
     * @param nombres Los nombres del beneficiario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del beneficiario.
     *
     * @return El apellido paterno del beneficiario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del beneficiario.
     *
     * @param apellidoPaterno El apellido paterno del beneficiario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del beneficiario.
     *
     * @return El apellido materno del beneficiario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del beneficiario.
     *
     * @param apellidoMaterno El apellido materno del beneficiario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el usuario del beneficiario.
     *
     * @return El usuario del beneficiario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario del beneficiario.
     *
     * @param usuario El usuario del beneficiario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del beneficiario.
     *
     * @return La contraseña del beneficiario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del beneficiario.
     *
     * @param contrasena La contraseña del beneficiario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la clave de contrato del beneficiario.
     *
     * @return La clave de contrato del beneficiario.
     */
    public String getClaveContrato() {
        return claveContrato;
    }

    /**
     * Establece la clave de contrato del beneficiario.
     *
     * @param claveContrato La clave de contrato del beneficiario.
     */
    public void setClaveContrato(String claveContrato) {
        this.claveContrato = claveContrato;
    }

    /**
     * Obtiene el saldo del beneficiario.
     *
     * @return El saldo del beneficiario.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo del beneficiario.
     *
     * @param saldo El saldo del beneficiario.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Verifica si el beneficiario está marcado como eliminado.
     *
     * @return true si el beneficiario está eliminado, false si no.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación del beneficiario.
     *
     * @param eliminado true para marcar como eliminado, false para no.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Obtiene la lista de cuentas bancarias asociadas al beneficiario.
     *
     * @return La lista de cuentas bancarias asociadas al beneficiario.
     */
    public List<CuentaBancariaEntidad> getCuentas() {
        return cuentas;
    }

    /**
     * Establece la lista de cuentas bancarias asociadas al beneficiario.
     *
     * @param cuentas La lista de cuentas bancarias asociadas al beneficiario.
     */
    public void setCuentas(List<CuentaBancariaEntidad> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Obtiene la lista de pagos realizados por el beneficiario.
     *
     * @return La lista de pagos realizados por el beneficiario.
     */
    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    /**
     * Establece la lista de pagos realizados por el beneficiario.
     *
     * @param pagos La lista de pagos realizados por el beneficiario.
     */
    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    /**
     * Representación en cadena de texto del objeto BeneficiarioEntidad.
     *
     * @return Cadena que representa el objeto BeneficiarioEntidad.
     */
    @Override
    public String toString() {
        return "BeneficiarioEntidad{"
                + "id=" + id
                + ", nombres='" + nombres + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", usuario='" + usuario + '\''
                + ", contrasena='" + contrasena + '\''
                + ", claveContrato='" + claveContrato + '\''
                + ", saldo=" + saldo
                + ", eliminado=" + eliminado
                + ", cuentas=" + cuentas
                + ", pagos=" + pagos
                + '}';
    }

}
