/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IAbonoDAO;
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
 *
 * @author caarl
 */
public class AbonoDAO implements IAbonoDAO {

    final IConexionBD conexion;

    public AbonoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void eliminarAbono(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            AbonoEntidad abonoExistente = em.find(AbonoEntidad.class, id);
            if (abonoExistente == null) {
                throw new PersistenciaException("El abono con ID " + id + " no existe");
            }
            abonoExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.persist(abonoExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el abono", e);
        }
    }

    @Override
    public void guardarAbono(AbonoEntidad abono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(abono);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar el abono", e);
        }
    }

    @Override
    public void modificarAbono(Long id, AbonoEntidad abono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            AbonoEntidad abonoExistente = em.find(AbonoEntidad.class, id);
            if (abonoExistente == null) {
                throw new PersistenciaException("El abono con ID " + id + " no existe");
            }
            abonoExistente.setFechaHora(abono.getFechaHora());
            abonoExistente.setMonto(abono.getMonto());
            abonoExistente.setPago(abono.getPago());
            em.persist(abonoExistente);
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al modificar el abono", e);
        }
    }

    @Override
    public void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            abono.setPago(pago);
            em.persist(abono);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar el abono con relación al pago", e);
        }
    }

    @Override
    public AbonoEntidad buscarAbono(AbonoEntidad abono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AbonoEntidad> criteria = cb.createQuery(AbonoEntidad.class);
        Root<AbonoEntidad> root = criteria.from(AbonoEntidad.class);
        criteria.select(root).where(cb.equal(root.get("idAbono"), abono.getId()));
        TypedQuery<AbonoEntidad> query = em.createQuery(criteria);
        AbonoEntidad abonos;
        try {
            abonos = (AbonoEntidad) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        }

        return abonos;
    }

    @Override
    public AbonoEntidad buscarAbonoPorId(Long idAbono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AbonoEntidad> criteria = cb.createQuery(AbonoEntidad.class);
        Root<AbonoEntidad> root = criteria.from(AbonoEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), idAbono));
        TypedQuery<AbonoEntidad> query = em.createQuery(criteria);
        AbonoEntidad abonos;
        try {
            abonos = query.getSingleResult();
        } catch (NoResultException nre) {
            throw new PersistenciaException("Abono no encontrado con id: " + idAbono);
        }
        return abonos;
    }

    @Override
    public List<AbonoEntidad> buscarAbonos() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AbonoEntidad> criteria = cb.createQuery(AbonoEntidad.class);
        Root<AbonoEntidad> root = criteria.from(AbonoEntidad.class);
        criteria.select(root);

        TypedQuery<AbonoEntidad> query = em.createQuery(criteria);
        List<AbonoEntidad> abonos;
        try {
            abonos = query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al buscar los abonos", e);
        }

        return abonos;
    }
}
