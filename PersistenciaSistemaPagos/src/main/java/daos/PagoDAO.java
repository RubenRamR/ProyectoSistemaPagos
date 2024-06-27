/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IPagoDAO;
import java.util.List;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * PagoEntidad. Implementa la interfaz IPagoDAO.
 */
public class PagoDAO implements IPagoDAO {

    final IConexionBD conexion;

    public PagoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Elimina un pago especificado por su ID.
     *
     * @param id El ID del pago a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarPago(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            PagoEntidad pagoExistente = em.find(PagoEntidad.class, id);
            if (pagoExistente == null)
            {
                throw new PersistenciaException("El pago con ID " + id + " no existe");
            }
            pagoExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.persist(pagoExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el pago", e);
        }
    }

    /**
     * Guarda un nuevo pago en la base de datos.
     *
     * @param pago El pago a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarPago(PagoEntidad pago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.persist(pago);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el pago", e);
        }
    }

    /**
     * Busca un pago en la base de datos basado en su ID.
     *
     * @param id El ID del pago a buscar.
     * @return El pago encontrado.
     * @throws PersistenciaException Si no se encuentra ningún pago con el ID
     * especificado.
     */
    @Override
    public PagoEntidad buscarPagoPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            return em.find(PagoEntidad.class, id);
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar el pago por ID", e);
        }
    }

    /**
     * Actualiza un pago existente en la base de datos.
     *
     * @param pago El pago con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public void actualizarPago(PagoEntidad pago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.merge(pago);
            em.getTransaction().commit();
            System.out.println("Operación de actualización terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el pago", e);
        }
    }

    /**
     * Busca todos los pagos almacenados en la base de datos.
     *
     * @return Una lista de todos los pagos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<PagoEntidad> buscarTodosPagos() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root);
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar todos los pagos", e);
        }
    }

    /**
     * Busca todos los pagos asociados a un beneficiario específico.
     *
     * @param idBeneficiario El ID del beneficiario.
     * @return Una lista de pagos asociados al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<PagoEntidad> buscarPagosPorBeneficiario(Long idBeneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root).where(cb.equal(root.get("beneficiario").get("id"), idBeneficiario));
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar pagos por beneficiario", e);
        }
    }

    /**
     * Busca todos los pagos realizados dentro de un rango de fechas específico.
     *
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de pagos realizados dentro del rango de fechas
     * especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<PagoEntidad> buscarPagosPorRangoFechas(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            Predicate fechaPredicate = cb.between(root.get("fechaHora"), fechaInicio, fechaFin);
            criteriaQuery.select(root).where(fechaPredicate);
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar pagos por rango de fechas", e);
        }
    }

    /**
     * Busca todos los pagos asociados a un tipo de pago específico.
     *
     * @param idTipoPago El ID del tipo de pago.
     * @return Una lista de pagos asociados al tipo de pago especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<PagoEntidad> buscarPagosPorTipoPago(Long idTipoPago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root).where(cb.equal(root.get("tipoPago").get("id"), idTipoPago));
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar pagos por tipo de pago", e);
        }
    }
}
