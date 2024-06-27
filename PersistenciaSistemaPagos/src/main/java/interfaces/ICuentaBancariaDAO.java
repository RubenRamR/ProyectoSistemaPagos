/*
 * Esta interfaz define el contrato para las operaciones de acceso a datos relacionadas con las cuentas bancarias.
 */
package interfaces;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define el contrato para las operaciones de acceso a datos
 * relacionadas con las cuentas bancarias.
 *
 * Proporciona métodos para guardar, modificar, buscar y eliminar cuentas
 * bancarias, así como operaciones con relaciones.
 *
 * También incluye métodos para obtener listas de cuentas bancarias por
 * identificador de beneficiario y otros criterios.
 *
 * @author Chris
 */
public interface ICuentaBancariaDAO {

    /**
     * Guarda una cuenta bancaria en la base de datos.
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    /**
     * Modifica una cuenta bancaria existente en la base de datos.
     *
     * @param id El ID de la cuenta bancaria a modificar.
     * @param cuentaBancaria La cuenta bancaria modificada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void modificarCuentaBancaria(Long id, CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    /**
     * Guarda una cuenta bancaria junto con sus relaciones a beneficiario y
     * pagos asociados.
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @param beneficiario El beneficiario asociado a la cuenta bancaria.
     * @param pagos La lista de pagos asociados a la cuenta bancaria.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaEntidad cuentaBancaria, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) throws PersistenciaException;

    /**
     * Obtiene una lista de cuentas bancarias por el ID del beneficiario
     * asociado.
     *
     * @param id El ID del beneficiario.
     * @return Lista de cuentas bancarias asociadas al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    List<CuentaBancariaEntidad> listaCuentasPorIdBeneficiario(Long id) throws PersistenciaException;

    /**
     * Busca una cuenta bancaria en la base de datos.
     *
     * @param cuentaBancaria La cuenta bancaria a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public CuentaBancariaEntidad buscarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    /**
     * Busca una cuenta bancaria por su ID en la base de datos.
     *
     * @param idCuentaBancaria El ID de la cuenta bancaria a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public CuentaBancariaEntidad buscarCuentaBancariaPorId(Long idCuentaBancaria) throws PersistenciaException;

    /**
     * Obtiene una lista de todas las cuentas bancarias almacenadas en la base
     * de datos.
     *
     * @return Lista de cuentas bancarias.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<CuentaBancariaEntidad> buscarCuentasBancarias() throws PersistenciaException;

    /**
     * Elimina una cuenta bancaria de la base de datos.
     *
     * @param id El ID de la cuenta bancaria a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void eliminarCuentaBancaria(Long id) throws PersistenciaException;

    /**
     * Obtiene una lista de cuentas bancarias asociadas a un beneficiario
     * específico.
     *
     * @param beneficiario El beneficiario para el cual se desean obtener las
     * cuentas bancarias.
     * @return Lista de cuentas bancarias asociadas al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<CuentaBancariaEntidad> buscarCuentasBancarias(BeneficiarioEntidad beneficiario) throws PersistenciaException;

}
