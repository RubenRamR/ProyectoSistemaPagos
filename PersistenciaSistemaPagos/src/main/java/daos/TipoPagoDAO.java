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

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * TipoPagoEntidad. Implementa la interfaz ITipoPagoDAO.
 */
public class TipoPagoDAO implements ITipoPagoDAO {

    final IConexionBD conexion;

    public TipoPagoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Guarda un nuevo tipo de pago en la base de datos.
     *
     * @param tipo El tipo de pago a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
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

    /**
     * Modifica un tipo de pago existente en la base de datos.
     *
     * @param id El ID del tipo de pago a modificar.
     * @param tipo El tipo de pago con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * modificación.
     */
    @Override
    public void modificarTipoPago(Long id, TipoPagoEntidad tipo) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            TipoPagoEntidad tipoPago = em.find(TipoPagoEntidad.class, id);
            if (tipoPago == null)
            {
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

    /**
     * Busca un tipo de pago en la base de datos basado en su ID.
     *
     * @param id El ID del tipo de pago a buscar.
     * @return El tipo de pago encontrado.
     * @throws PersistenciaException Si no se encuentra ningún tipo de pago con
     * el ID especificado.
     */
    @Override
    public TipoPagoEntidad buscarTipoPagoPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            return em.find(TipoPagoEntidad.class, id);
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar el tipo de pago por ID", e);
        }
    }

    /**
     * Busca todos los tipos de pago almacenados en la base de datos.
     *
     * @return Una lista de todos los tipos de pago.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<TipoPagoEntidad> buscarTodosTiposPago() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaQuery<TipoPagoEntidad> criteriaQuery = em.getCriteriaBuilder().createQuery(TipoPagoEntidad.class);
            criteriaQuery.select(criteriaQuery.from(TipoPagoEntidad.class));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar todos los tipos de pago", e);
        }
    }

    /**
     * Elimina un tipo de pago de la base de datos basado en su ID.
     *
     * @param id El ID del tipo de pago a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarTipoPago(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            TipoPagoEntidad tipoPago = em.find(TipoPagoEntidad.class, id);
            if (tipoPago != null)
            {
                em.remove(tipoPago);
            }
            em.getTransaction().commit();
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar el tipo de pago", e);
        }
    }

    /**
     * Busca todos los tipos de pago cuyo nombre coincida parcialmente con el
     * nombre especificado.
     *
     * @param nombre El nombre (o parte del nombre) a buscar.
     * @return Una lista de tipos de pago cuyos nombres coinciden con la
     * búsqueda.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<TipoPagoEntidad> buscarTiposPagoPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TipoPagoEntidad> criteriaQuery = cb.createQuery(TipoPagoEntidad.class);
            Root<TipoPagoEntidad> root = criteriaQuery.from(TipoPagoEntidad.class);
            criteriaQuery.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (PersistenceException e)
        {
            throw new PersistenciaException("Error al buscar tipos de pago por nombre", e);
        }
    }
}
