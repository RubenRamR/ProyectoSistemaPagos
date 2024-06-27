/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio relacionadas con las cuentas
 * bancarias.
 */
public interface ICuentaBancariaNegocio {

    /**
     * Método para guardar una cuenta bancaria en el sistema.
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public void guardarCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws NegocioException;

    /**
     * Método para modificar una cuenta bancaria existente en el sistema.
     *
     * @param cuentaBancaria Los datos actualizados de la cuenta bancaria.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public void modificarCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws NegocioException;

    /**
     * Método para guardar una cuenta bancaria junto con sus relaciones de
     * beneficiario y pagos.
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @param beneficiario El beneficiario asociado a la cuenta bancaria.
     * @param pagos La lista de pagos asociados a la cuenta bancaria.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaDTO cuentaBancaria, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) throws NegocioException;

    /**
     * Método para obtener una lista de cuentas bancarias por ID de
     * beneficiario.
     *
     * @param id ID del beneficiario.
     * @return La lista de cuentas bancarias asociadas al beneficiario.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public List<CuentaBancariaDTO> listaCuentasPorIdBeneficiario(Long id) throws NegocioException;

    /**
     * Método para buscar una cuenta bancaria en el sistema.
     *
     * @param cuentaBancariaDTO La cuenta bancaria a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public CuentaBancariaDTO buscarCuentaBancariaDTO(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException;

    /**
     * Método para buscar una cuenta bancaria por su ID.
     *
     * @param id ID de la cuenta bancaria a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public CuentaBancariaDTO buscarCuentaBancariaPorId(Long id) throws NegocioException;

    /**
     * Método para eliminar una cuenta bancaria del sistema.
     *
     * @param id ID de la cuenta bancaria a eliminar.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    void eliminarCuentaBancaria(Long id) throws NegocioException;

    /**
     * Método para buscar cuentas bancarias de un beneficiario específico.
     *
     * @param beneficiario El beneficiario del cual se buscan las cuentas
     * bancarias.
     * @return La lista de cuentas bancarias del beneficiario.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public List<CuentaBancariaDTO> buscarCuentasBancarias(BeneficiarioDTO beneficiario) throws NegocioException;

}
