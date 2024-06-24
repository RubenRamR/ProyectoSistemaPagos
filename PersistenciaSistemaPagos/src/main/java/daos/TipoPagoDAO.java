/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITipoPagoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TipoPagoDAO implements ITipoPagoDAO {
    final IConexionBD conexion;

    public TipoPagoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    


    @Override
    public void guardarTipoPago(TipoPagoEntidad tipo) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.persist(tipo);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el tipo de pago", e);
        }
    }

    @Override
    public void modificarTipoPago(Long id, TipoPagoEntidad tipo) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            TipoPagoEntidad tipoPago = em.find(TipoPagoEntidad.class, id);
            if (tipoPago == null)
            {
                throw new PersistenciaException("La cuenta bancaria con ID " + id + " no existe");
            if (tipoPago == null) {
                throw new PersistenciaException("El tipo de pago con ID " + id + " no existe");
            }
            tipoPago.setNombre(tipo.getNombre());
            tipoPago.setNumMensualidades(tipo.getNumMensualidades());
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar el tipo de pago", e);
        }
    }

    @Override
    public TipoPagoEntidad buscarTipoPagoPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            return em.find(TipoPagoEntidad.class, id);
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar el tipo de pago por ID", e);
        }
    }

    @Override
    public List<TipoPagoEntidad> buscarTodosTiposPago() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaQuery<TipoPagoEntidad> criteriaQuery = em.getCriteriaBuilder().createQuery(TipoPagoEntidad.class);
            criteriaQuery.select(criteriaQuery.from(TipoPagoEntidad.class));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar todos los tipos de pago", e);
        }
    }

    @Override
    public void eliminarTipoPago(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            TipoPagoEntidad tipoPago = em.find(TipoPagoEntidad.class, id);
            if (tipoPago != null) {
                em.remove(tipoPago);
            }
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el tipo de pago", e);
        }
    }

    @Override
    public List<TipoPagoEntidad> buscarTiposPagoPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TipoPagoEntidad> criteriaQuery = cb.createQuery(TipoPagoEntidad.class);
            Root<TipoPagoEntidad> root = criteriaQuery.from(TipoPagoEntidad.class);
            criteriaQuery.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar tipos de pago por nombre", e);
        }
    }
}
