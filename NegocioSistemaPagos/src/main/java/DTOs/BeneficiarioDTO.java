/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa la información de un beneficiario.
 */
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
    private CuentaBancariaDTO cuenta;
    private List<PagoDTO> pagos;
    private boolean eliminado;

    /**
     * Constructor vacío de BeneficiarioDTO.
     */
    public BeneficiarioDTO() {
    }

    /**
     * Constructor de BeneficiarioDTO con parámetros.
     *
     * @param nombres Nombres del beneficiario.
     * @param apellidoPaterno Apellido paterno del beneficiario.
     * @param apellidoMaterno Apellido materno del beneficiario.
     * @param usuario Usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @param claveContrato Clave de contrato del beneficiario.
     * @param saldo Saldo del beneficiario.
     * @param cuentas Lista de cuentas bancarias del beneficiario.
     * @param pagos Lista de pagos del beneficiario.
     */
    public BeneficiarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String usuario,
            String contrasena, String claveContrato, float saldo, List<CuentaBancariaDTO> cuentas,
            List<PagoDTO> pagos) {
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

    /**
     * Constructor de BeneficiarioDTO con parámetros incluyendo el ID.
     *
     * @param id ID del beneficiario.
     * @param nombres Nombres del beneficiario.
     * @param apellidoPaterno Apellido paterno del beneficiario.
     * @param apellidoMaterno Apellido materno del beneficiario.
     * @param usuario Usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @param claveContrato Clave de contrato del beneficiario.
     * @param saldo Saldo del beneficiario.
     * @param cuentas Lista de cuentas bancarias del beneficiario.
     * @param pagos Lista de pagos del beneficiario.
     */
    public BeneficiarioDTO(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String usuario,
            String contrasena, String claveContrato, float saldo, List<CuentaBancariaDTO> cuentas,
            List<PagoDTO> pagos) {
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

    /**
     * Método para obtener el ID del beneficiario.
     *
     * @return El ID del beneficiario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID del beneficiario.
     *
     * @param id El ID del beneficiario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener los nombres del beneficiario.
     *
     * @return Los nombres del beneficiario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método para establecer los nombres del beneficiario.
     *
     * @param nombres Los nombres del beneficiario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método para obtener el apellido paterno del beneficiario.
     *
     * @return El apellido paterno del beneficiario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método para establecer el apellido paterno del beneficiario.
     *
     * @param apellidoPaterno El apellido paterno del beneficiario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método para obtener el apellido materno del beneficiario.
     *
     * @return El apellido materno del beneficiario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método para establecer el apellido materno del beneficiario.
     *
     * @param apellidoMaterno El apellido materno del beneficiario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método para obtener el usuario del beneficiario.
     *
     * @return El usuario del beneficiario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el usuario del beneficiario.
     *
     * @param usuario El usuario del beneficiario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la contraseña del beneficiario.
     *
     * @return La contraseña del beneficiario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método para establecer la contraseña del beneficiario.
     *
     * @param contrasena La contraseña del beneficiario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método para obtener la clave de contrato del beneficiario.
     *
     * @return La clave de contrato del beneficiario.
     */
    public String getClaveContrato() {
        return claveContrato;
    }

    /**
     * Método para establecer la clave de contrato del beneficiario.
     *
     * @param claveContrato La clave de contrato del beneficiario.
     */
    public void setClaveContrato(String claveContrato) {
        this.claveContrato = claveContrato;
    }

    /**
     * Método para obtener el saldo del beneficiario.
     *
     * @return El saldo del beneficiario.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Método para establecer el saldo del beneficiario.
     *
     * @param saldo El saldo del beneficiario.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Método para obtener la lista de cuentas bancarias del beneficiario.
     *
     * @return La lista de cuentas bancarias del beneficiario.
     */
    public List<CuentaBancariaDTO> getCuentas() {
        return cuentas;
    }

    /**
     * Método para establecer la lista de cuentas bancarias del beneficiario.
     *
     * @param cuentas La lista de cuentas bancarias del beneficiario.
     */
    public void setCuentas(List<CuentaBancariaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Método para obtener la cuenta bancaria del beneficiario.
     *
     * @return La cuenta bancaria del beneficiario.
     */
    public CuentaBancariaDTO getCuenta() {
        return cuenta;
    }

    /**
     * Método para establecer la cuenta bancaria del beneficiario.
     *
     * @param cuenta La cuenta bancaria del beneficiario.
     */
    public void setCuenta(CuentaBancariaDTO cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método para obtener la lista de pagos del beneficiario.
     *
     * @return La lista de pagos del beneficiario.
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * Método para establecer la lista de pagos del beneficiario.
     *
     * @param pagos La lista de pagos del beneficiario.
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * Método para verificar si el beneficiario está marcado como eliminado.
     *
     * @return true si el beneficiario está eliminado, false en caso contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método para establecer el estado de eliminado del beneficiario.
     *
     * @param eliminado true si se desea marcar como eliminado, false en caso
     * contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Retorna una representación en cadena del objeto BeneficiarioDTO.
     *
     * @return Cadena que representa el objeto BeneficiarioDTO.
     */
    @Override
    public String toString() {
        return "BeneficiarioDTO{"
                + "id=" + id
                + ", nombres='" + nombres + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", usuario='" + usuario + '\''
                + ", contrasena='" + contrasena + '\''
                + ", claveContrato='" + claveContrato + '\''
                + ", saldo=" + saldo
                + ", cuentas=" + cuentas
                + ", pagos=" + pagos
                + ", eliminado=" + eliminado
                + '}';
    }
}
