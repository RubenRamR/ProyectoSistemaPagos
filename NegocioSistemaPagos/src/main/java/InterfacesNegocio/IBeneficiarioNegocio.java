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
 * Interfaz que define las operaciones de negocio relacionadas con los beneficiarios.
 */
public interface IBeneficiarioNegocio {

    /**
     * Método para guardar un beneficiario en el sistema.
     *
     * @param beneficiario El beneficiario a guardar.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void guardarBeneficiario(BeneficiarioDTO beneficiario) throws NegocioException;

    /**
     * Método para modificar un beneficiario existente en el sistema.
     *
     * @param id ID del beneficiario a modificar.
     * @param beneficiario Los datos actualizados del beneficiario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void modificarBeneficiario(Long id, BeneficiarioDTO beneficiario) throws NegocioException;

    /**
     * Método para buscar un beneficiario en el sistema.
     *
     * @param beneficiario El beneficiario a buscar.
     * @return El beneficiario encontrado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public BeneficiarioDTO buscarBeneficiarioDTO(BeneficiarioDTO beneficiario) throws NegocioException;

    /**
     * Método para guardar un beneficiario junto con sus relaciones de cuentas bancarias y pagos.
     *
     * @param beneficiario El beneficiario a guardar.
     * @param cuentas La lista de cuentas bancarias del beneficiario.
     * @param pagos La lista de pagos del beneficiario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException;

    /**
     * Método para buscar una lista de beneficiarios paginada.
     *
     * @param limit El número máximo de resultados por página.
     * @param pagina El número de página.
     * @return La lista de beneficiarios encontrados.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<BeneficiarioDTO> buscarBeneficiarios(int limit, int pagina) throws NegocioException;

    /**
     * Método para eliminar un beneficiario del sistema.
     *
     * @param id ID del beneficiario a eliminar.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    void eliminarBeneficiario(Long id) throws NegocioException;

    /**
     * Método para buscar un beneficiario por su ID.
     *
     * @param idBo ID del beneficiario a buscar.
     * @return El beneficiario encontrado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public BeneficiarioDTO buscarBeneficiarioPorId(Long idBo) throws NegocioException;

    /**
     * Método para realizar el login de un beneficiario.
     *
     * @param usuario El nombre de usuario del beneficiario.
     * @param contrasena La contraseña del beneficiario.
     * @return El beneficiario que ha iniciado sesión.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public BeneficiarioDTO loginBeneficiario(String usuario, String contrasena) throws NegocioException;

}
