/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;



/**
 *
 * @author Chris
 */

import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.Calendar;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Pago.
 */
public interface IPagoDAO {

    /**
     * Guarda un nuevo pago en la base de datos.
     *
     * @param pago El objeto PagoEntidad a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    void guardarPago(PagoEntidad pago) throws PersistenciaException;

    /**
     * Busca un pago por su ID.
     *
     * @param id El ID del pago a buscar.
     * @return El objeto PagoEntidad encontrado, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    PagoEntidad buscarPagoPorId(Long id) throws PersistenciaException;

    /**
     * Actualiza la información de un pago existente.
     *
     * @param pago El objeto PagoEntidad con la información actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización.
     */
    void actualizarPago(PagoEntidad pago) throws PersistenciaException;

    /**
     * Elimina un pago de la base de datos.
     *
     * @param id El ID del pago a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminarPago(Long id) throws PersistenciaException;

    /**
     * Busca todos los pagos en la base de datos.
     *
     * @return Una lista de todos los objetos PagoEntidad.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<PagoEntidad> buscarTodosPagos() throws PersistenciaException;

    /**
     * Busca pagos por beneficiario.
     *
     * @param idBeneficiario El ID del beneficiario.
     * @return Una lista de PagoEntidad asociados al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<PagoEntidad> buscarPagosPorBeneficiario(Long idBeneficiario) throws PersistenciaException;

    /**
     * Busca pagos por rango de fechas.
     *
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de PagoEntidad dentro del rango de fechas especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<PagoEntidad> buscarPagosPorRangoFechas(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException;

    /**
     * Busca pagos por tipo de pago.
     *
     * @param idTipoPago El ID del tipo de pago.
     * @return Una lista de PagoEntidad asociados al tipo de pago especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<PagoEntidad> buscarPagosPorTipoPago(Long idTipoPago) throws PersistenciaException;
}