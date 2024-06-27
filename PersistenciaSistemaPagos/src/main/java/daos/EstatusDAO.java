/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.EstatusEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstatusDAO;
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
 * EstatusEntidad. Implementa la interfaz IEstatusDAO.
 */
public class EstatusDAO implements IEstatusDAO {

    final IConexionBD conexion;

    public EstatusDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Elimina un estatus especificado por su ID.
     *
     * @param id El ID del estatus a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarEstatus(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            EstatusEntidad estatusExistente = em.find(EstatusEntidad.class, id);
            if (estatusExistente == null)
            {
                throw new PersistenciaException("El estatus con ID " + id + " no existe");
            }
            estatusExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.persist(estatusExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el estatus", e);
        }
    }

    /**
     * Guarda un nuevo estatus en la base de datos.
     *
     * @param estatus El estatus a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarEstatus(EstatusEntidad estatus) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.persist(estatus);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el estatus", e);
        }
    }

    /**
     * Modifica un estatus existente en la base de datos.
     *
     * @param id El ID del estatus a modificar.
     * @param estatus El estatus con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la modificación.
     */
    @Override
    public void modificarEstatus(Long id, EstatusEntidad estatus) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            EstatusEntidad estatusExistente = em.find(EstatusEntidad.class, id);
            if (estatusExistente == null)
            {
                throw new PersistenciaException("El estatus con ID " + id + " no existe");
            }
            estatusExistente.setNombre(estatus.getNombre());
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar el estatus", e);
        }
    }

    /**
     * Busca un estatus en la base de datos basado en su ID.
     *
     * @param idEstatus El ID del estatus a buscar.
     * @return El estatus encontrado.
     * @throws PersistenciaException Si no se encuentra ningún estatus con el ID
     * especificado.
     */
    @Override
    public EstatusEntidad buscarEstatusPorId(Long idEstatus) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstatusEntidad> criteria = cb.createQuery(EstatusEntidad.class);
        Root<EstatusEntidad> root = criteria.from(EstatusEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), idEstatus));
        TypedQuery<EstatusEntidad> query = em.createQuery(criteria);
        EstatusEntidad estatus;
        try
        {
            estatus = query.getSingleResult();
        } catch (NoResultException nre)
        {
            throw new PersistenciaException("Estatus no encontrado con id: " + idEstatus);
        }
        return estatus;
    }

    /**
     * Busca todos los estatus almacenados en la base de datos.
     *
     * @return Una lista de todos los estatus.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<EstatusEntidad> buscarTodosLosEstatus() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstatusEntidad> criteria = cb.createQuery(EstatusEntidad.class);
        Root<EstatusEntidad> root = criteria.from(EstatusEntidad.class);
        criteria.select(root);
        TypedQuery<EstatusEntidad> query = em.createQuery(criteria);
        List<EstatusEntidad> estatusList;
        try
        {
            estatusList = query.getResultList();
        } catch (Exception e)
        {
            throw new PersistenciaException("Error al buscar todos los estatus", e);
        }
        return estatusList;
    }
}
