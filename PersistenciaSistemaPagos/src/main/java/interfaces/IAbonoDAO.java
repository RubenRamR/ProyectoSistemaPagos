/*
 * Esta interfaz define las operaciones que deben ser implementadas por una clase DAO para AbonoEntidad.
 * Las operaciones incluyen guardar, modificar, buscar por diferentes criterios, y eliminar abonos.
 */
package interfaces;

import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad AbonoEntidad. Estas
 * operaciones permiten gestionar abonos asociados a pagos en el sistema.
 *
 * Las operaciones incluyen guardar, modificar, buscar por diferentes criterios,
 * y eliminar abonos.
 *
 * @author caarl
 */
public interface IAbonoDAO {

    /**
     * Guarda un abono en el sistema.
     *
     * @param abono El abono a guardar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void guardarAbono(AbonoEntidad abono) throws PersistenciaException;

    /**
     * Modifica un abono existente en el sistema.
     *
     * @param id El ID del abono a modificar.
     * @param abono El abono con los cambios a aplicar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void modificarAbono(Long id, AbonoEntidad abono) throws PersistenciaException;

    /**
     * Guarda un abono estableciendo la relación con un pago específico.
     *
     * @param abono El abono a guardar.
     * @param pago El pago al cual se relaciona el abono.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) throws PersistenciaException;

    /**
     * Busca un abono en el sistema basado en el abono proporcionado.
     *
     * @param abono El abono con los criterios de búsqueda.
     * @return El abono encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    AbonoEntidad buscarAbono(AbonoEntidad abono) throws PersistenciaException;

    /**
     * Busca un abono en el sistema basado en su ID.
     *
     * @param idAbono El ID del abono a buscar.
     * @return El abono encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    AbonoEntidad buscarAbonoPorId(Long idAbono) throws PersistenciaException;

    /**
     * Elimina un abono del sistema basado en su ID.
     *
     * @param id El ID del abono a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void eliminarAbono(Long id) throws PersistenciaException;

    /**
     * Busca y devuelve todos los abonos registrados en el sistema.
     *
     * @return Una lista de todos los abonos registrados.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    List<AbonoEntidad> buscarAbonos() throws PersistenciaException;
}
