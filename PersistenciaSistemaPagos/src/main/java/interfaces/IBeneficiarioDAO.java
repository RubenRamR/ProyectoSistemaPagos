/*
 * Esta interfaz define las operaciones que deben ser implementadas por una clase DAO para BeneficiarioEntidad.
 * Las operaciones incluyen guardar, modificar, buscar por diferentes criterios, y eliminar beneficiarios.
 */
package interfaces;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad BeneficiarioEntidad.
 * Estas operaciones permiten gestionar beneficiarios en el sistema, incluyendo
 * relaciones con cuentas bancarias y pagos.
 *
 * Las operaciones incluyen guardar, modificar, buscar por diferentes criterios,
 * y eliminar beneficiarios.
 *
 * Además, se incluye un método para autenticar un beneficiario mediante un
 * usuario y contraseña.
 *
 * @author caarl
 */
public interface IBeneficiarioDAO {

    /**
     * Guarda un beneficiario en el sistema.
     *
     * @param beneficiario El beneficiario a guardar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void guardarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException;

    /**
     * Modifica un beneficiario existente en el sistema.
     *
     * @param beneficiario El beneficiario con los cambios a aplicar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void modificarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException;

    /**
     * Guarda un beneficiario estableciendo relaciones con cuentas bancarias y
     * pagos.
     *
     * @param beneficiario El beneficiario a guardar.
     * @param cuentas Las cuentas bancarias asociadas al beneficiario.
     * @param pagos Los pagos asociados al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) throws PersistenciaException;

    /**
     * Busca un beneficiario en el sistema basado en el beneficiario
     * proporcionado.
     *
     * @param beneficiario El beneficiario con los criterios de búsqueda.
     * @return El beneficiario encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public BeneficiarioEntidad buscarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException;

    /**
     * Busca un beneficiario en el sistema basado en su ID.
     *
     * @param idBeneficiario El ID del beneficiario a buscar.
     * @return El beneficiario encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public BeneficiarioEntidad buscarBeneficiarioPorId(Long idBeneficiario) throws PersistenciaException;

    /**
     * Busca y devuelve una lista de beneficiarios basados en un límite y una
     * página específicos.
     *
     * @param limite El límite de resultados por página.
     * @param pagina El número de página.
     * @return Una lista de beneficiarios según el límite y la página
     * especificados.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<BeneficiarioEntidad> buscarBeneficiarios(int limite, int pagina) throws PersistenciaException;

    /**
     * Busca y devuelve todos los beneficiarios registrados en el sistema.
     *
     * @return Una lista de todos los beneficiarios registrados.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<BeneficiarioEntidad> buscarBeneficiarios() throws PersistenciaException;

    /**
     * Elimina un beneficiario del sistema basado en su ID.
     *
     * @param id El ID del beneficiario a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void eliminarBeneficiario(Long id) throws PersistenciaException;

    /**
     * Autentica un beneficiario en el sistema mediante un usuario y contraseña.
     *
     * @param usuario El nombre de usuario del beneficiario.
     * @param contrasena La contraseña del beneficiario.
     * @return El beneficiario autenticado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public BeneficiarioEntidad loginBeneficiario(String usuario, String contrasena) throws PersistenciaException;

}
