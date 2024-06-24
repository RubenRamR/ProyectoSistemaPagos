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

public class PagoDAO implements IPagoDAO {

    final IConexionBD conexion;

    public PagoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void eliminarPago(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            PagoEntidad pagoExistente = em.find(PagoEntidad.class, id);
            if (pagoExistente == null) {
                throw new PersistenciaException("El pago con ID " + id + " no existe");
            }
            pagoExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.persist(pagoExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el pago", e);
        }
    }

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

    @Override
    public PagoEntidad buscarPagoPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            return em.find(PagoEntidad.class, id);
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar el pago por ID", e);
        }
    }

    @Override
    public void actualizarPago(PagoEntidad pago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(pago);
            em.getTransaction().commit();
            System.out.println("Operación de actualización terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el pago", e);
        }
    }



    @Override
    public List<PagoEntidad> buscarTodosPagos() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root);
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar todos los pagos", e);
        }
    }

    @Override
    public List<PagoEntidad> buscarPagosPorBeneficiario(Long idBeneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root).where(cb.equal(root.get("beneficiario").get("id"), idBeneficiario));
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar pagos por beneficiario", e);
        }
    }

    @Override
    public List<PagoEntidad> buscarPagosPorRangoFechas(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            Predicate fechaPredicate = cb.between(root.get("fechaHora"), fechaInicio, fechaFin);
            criteriaQuery.select(root).where(fechaPredicate);
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar pagos por rango de fechas", e);
        }
    }

    @Override
    public List<PagoEntidad> buscarPagosPorTipoPago(Long idTipoPago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PagoEntidad> criteriaQuery = cb.createQuery(PagoEntidad.class);
            Root<PagoEntidad> root = criteriaQuery.from(PagoEntidad.class);
            criteriaQuery.select(root).where(cb.equal(root.get("tipoPago").get("id"), idTipoPago));
            TypedQuery<PagoEntidad> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar pagos por tipo de pago", e);
        }
    }
}
