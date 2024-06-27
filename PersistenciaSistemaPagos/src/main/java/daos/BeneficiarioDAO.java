/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * BeneficiarioEntidad. Implementa la interfaz IBeneficiarioDAO.
 */
public class BeneficiarioDAO implements IBeneficiarioDAO {

    final IConexionBD conexion;

    public BeneficiarioDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Elimina un beneficiario especificado por su ID.
     *
     * @param id El ID del beneficiario a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarBeneficiario(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            BeneficiarioEntidad beneficiarioExistente = em.find(BeneficiarioEntidad.class, id);
            if (beneficiarioExistente == null) {
                throw new PersistenciaException("El beneficiario con ID " + id + " no existe");
            }
            beneficiarioExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.merge(beneficiarioExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el beneficiario", e);
        }
    }

    /**
     * Guarda un nuevo beneficiario en la base de datos.
     *
     * @param beneficiario El beneficiario a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(beneficiario);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el beneficiario", e);
        }
    }

    /**
     * Modifica un beneficiario existente en la base de datos.
     *
     * @param beneficiario El beneficiario con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la modificación.
     */
    @Override
    public void modificarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(beneficiario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar beneficiario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Guarda un beneficiario con sus relaciones (cuentas bancarias y pagos).
     *
     * @param beneficiario El beneficiario a guardar.
     * @param cuentas La lista de cuentas bancarias asociadas al beneficiario.
     * @param pagos La lista de pagos asociados al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            beneficiario.setCuentas(cuentas);
            beneficiario.setPagos(pagos);
            em.persist(beneficiario);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el beneficiario con relaciones", e);
        }
    }

    /**
     * Busca un beneficiario en la base de datos basado en el objeto
     * beneficiario proporcionado.
     *
     * @param beneficiario El beneficiario con el ID a buscar.
     * @return El beneficiario encontrado.
     * @throws PersistenciaException Si no se encuentra ningún beneficiario con
     * el ID especificado.
     */
    @Override
    public BeneficiarioEntidad buscarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
        Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), beneficiario.getId()));
        TypedQuery<BeneficiarioEntidad> query = em.createQuery(criteria);
        BeneficiarioEntidad beneficiarios;
        try {
            beneficiarios = (BeneficiarioEntidad) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        }
        return beneficiarios;
    }

    /**
     * Busca un beneficiario en la base de datos basado en su ID.
     *
     * @param idBeneficiario El ID del beneficiario a buscar.
     * @return El beneficiario encontrado.
     * @throws PersistenciaException Si no se encuentra ningún beneficiario con
     * el ID especificado.
     */
    @Override
    public BeneficiarioEntidad buscarBeneficiarioPorId(Long idBeneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
        Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), idBeneficiario));
        TypedQuery<BeneficiarioEntidad> query = em.createQuery(criteria);
        BeneficiarioEntidad beneficiario;
        try {
            beneficiario = query.getSingleResult();
        } catch (NoResultException nre) {
            throw new PersistenciaException("Beneficiario no encontrado con id: " + idBeneficiario);
        }
        return beneficiario;
    }

    /**
     * Busca todos los beneficiarios no eliminados en la base de datos.
     *
     * @param limite El número máximo de resultados a devolver.
     * @param offset El número de resultados que se deben omitir desde el
     * principio.
     * @return Una lista de beneficiarios.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<BeneficiarioEntidad> buscarBeneficiarios(int limite, int offset) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
        Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);
        criteria.select(root).where(cb.equal(root.get("eliminado"), false));

        TypedQuery<BeneficiarioEntidad> query = em.createQuery(criteria);

        query.setFirstResult(offset);
        query.setMaxResults(limite);

        List<BeneficiarioEntidad> beneficiarios;
        try {
            beneficiarios = query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar beneficiarios", e);
        }
        return beneficiarios;
    }

    @Override
    public List<BeneficiarioEntidad> buscarBeneficiarios() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Autentica un beneficiario en el sistema mediante un usuario.
     *
     * @param usuario El nombre de usuario del beneficiario.
     * @return El beneficiario autenticado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    @Override
    public BeneficiarioEntidad buscarPorUsuario(String usuario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
        Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);
        criteria.select(root).where(cb.equal(root.get("usuario"), usuario));
        TypedQuery<BeneficiarioEntidad> query = em.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
    }

}
