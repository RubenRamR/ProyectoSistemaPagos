/*
 * Interfaz que define el contrato para las operaciones de acceso a datos relacionadas con los tipos de pago.
 */
package interfaces;

import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define el contrato para las operaciones de acceso a datos
 * relacionadas con los tipos de pago.
 *
 * Proporciona métodos para guardar, modificar, buscar y eliminar tipos de pago
 * en la base de datos.
 *
 * También incluye métodos para buscar tipos de pago por su ID, nombre
 * específico y obtener una lista de todos los tipos de pago almacenados.
 *
 * @author Chris
 */
public interface ITipoPagoDAO {

    /**
     * Guarda un nuevo tipo de pago en la base de datos.
     *
     * @param tipo El objeto TipoPagoEntidad a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    void guardarTipoPago(TipoPagoEntidad tipo) throws PersistenciaException;

    /**
     * Modifica un tipo de pago existente en la base de datos.
     *
     * @param id El ID del tipo de pago a modificar.
     * @param tipo El objeto TipoPagoEntidad con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * modificación o si el tipo de pago no existe.
     */
    void modificarTipoPago(Long id, TipoPagoEntidad tipo) throws PersistenciaException;

    /**
     * Busca un tipo de pago por su ID.
     *
     * @param id El ID del tipo de pago a buscar.
     * @return El objeto TipoPagoEntidad encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda o si
     * no se encuentra el tipo de pago.
     */
    TipoPagoEntidad buscarTipoPagoPorId(Long id) throws PersistenciaException;

    /**
     * Busca todos los tipos de pago en la base de datos.
     *
     * @return Una lista de todos los objetos TipoPagoEntidad.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<TipoPagoEntidad> buscarTodosTiposPago() throws PersistenciaException;

    /**
     * Elimina un tipo de pago de la base de datos.
     *
     * @param id El ID del tipo de pago a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * eliminación o si el tipo de pago no existe.
     */
    void eliminarTipoPago(Long id) throws PersistenciaException;

    /**
     * Busca tipos de pago por su nombre.
     *
     * @param nombre El nombre del tipo de pago a buscar.
     * @return Una lista de objetos TipoPagoEntidad que coinciden con el nombre
     * especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<TipoPagoEntidad> buscarTiposPagoPorNombre(String nombre) throws PersistenciaException;
}
