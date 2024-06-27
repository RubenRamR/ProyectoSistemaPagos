/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa la información de una cuenta
 * bancaria.
 */
public class CuentaBancariaDTO {

    private Long id;
    private long numeroCuenta;
    private String clave;
    private String banco;
    private boolean eliminado;
    private BeneficiarioDTO beneficiario;
    private List<PagoDTO> pagos;

    /**
     * Constructor vacío de CuentaBancariaDTO.
     */
    public CuentaBancariaDTO() {
    }

    /**
     * Constructor de CuentaBancariaDTO con parámetros.
     *
     * @param numeroCuenta Número de cuenta bancaria.
     * @param clave Clave de acceso a la cuenta.
     * @param banco Nombre del banco asociado a la cuenta.
     * @param eliminado Indicador de si la cuenta está eliminada o no.
     * @param beneficiario Beneficiario asociado a la cuenta.
     */
    public CuentaBancariaDTO(long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioDTO beneficiario) {
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
    }

    /**
     * Constructor de CuentaBancariaDTO con parámetros incluyendo el ID.
     *
     * @param id ID de la cuenta bancaria.
     * @param numeroCuenta Número de cuenta bancaria.
     * @param clave Clave de acceso a la cuenta.
     * @param banco Nombre del banco asociado a la cuenta.
     * @param eliminado Indicador de si la cuenta está eliminada o no.
     * @param beneficiario Beneficiario asociado a la cuenta.
     */
    public CuentaBancariaDTO(Long id, long numeroCuenta, String clave, String banco, boolean eliminado, BeneficiarioDTO beneficiario) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.banco = banco;
        this.eliminado = eliminado;
        this.beneficiario = beneficiario;
    }

    /**
     * Método para obtener el ID de la cuenta bancaria.
     *
     * @return El ID de la cuenta bancaria.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID de la cuenta bancaria.
     *
     * @param id El ID de la cuenta bancaria.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de cuenta bancaria.
     *
     * @return El número de cuenta bancaria.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método para establecer el número de cuenta bancaria.
     *
     * @param numeroCuenta El número de cuenta bancaria.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método para obtener la clave de acceso a la cuenta.
     *
     * @return La clave de acceso a la cuenta.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método para establecer la clave de acceso a la cuenta.
     *
     * @param clave La clave de acceso a la cuenta.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método para obtener el nombre del banco asociado a la cuenta.
     *
     * @return El nombre del banco asociado a la cuenta.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Método para establecer el nombre del banco asociado a la cuenta.
     *
     * @param banco El nombre del banco asociado a la cuenta.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Método para verificar si la cuenta está marcada como eliminada.
     *
     * @return true si la cuenta está eliminada, false en caso contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método para establecer el estado de eliminación de la cuenta.
     *
     * @param eliminado true si se desea marcar como eliminada, false en caso
     * contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método para obtener el beneficiario asociado a la cuenta.
     *
     * @return El beneficiario asociado a la cuenta.
     */
    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método para establecer el beneficiario asociado a la cuenta.
     *
     * @param beneficiario El beneficiario asociado a la cuenta.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método para obtener la lista de pagos asociados a la cuenta.
     *
     * @return La lista de pagos asociados a la cuenta.
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * Método para establecer la lista de pagos asociados a la cuenta.
     *
     * @param pagos La lista de pagos asociados a la cuenta.
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * Retorna una representación en cadena del objeto CuentaBancariaDTO.
     *
     * @return Cadena que representa el objeto CuentaBancariaDTO.
     */
    @Override
    public String toString() {
        return "CuentaBancariaDTO{"
                + "id=" + id
                + ", numeroCuenta=" + numeroCuenta
                + ", clave='" + clave + '\''
                + ", banco='" + banco + '\''
                + ", eliminado=" + eliminado
                + ", beneficiario=" + beneficiario
                + ", pagos=" + pagos
                + '}';
    }
}
