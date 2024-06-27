/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentaBancariaDAO;
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
 * CuentaBancariaEntidad. Implementa la interfaz ICuentaBancariaDAO.
 */
public class CuentaBancariaDAO implements ICuentaBancariaDAO {

    final IConexionBD conexion;

    public CuentaBancariaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Elimina una cuenta bancaria especificada por su ID.
     *
     * @param id El ID de la cuenta bancaria a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarCuentaBancaria(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            CuentaBancariaEntidad cuentaBancariaExistente = em.find(CuentaBancariaEntidad.class, id);
            if (cuentaBancariaExistente == null) {
                throw new PersistenciaException("La cuenta bancaria con ID " + id + " no existe");
            }
            cuentaBancariaExistente.setEliminado(true); // Cambiar la columna "eliminado" a true
            em.persist(cuentaBancariaExistente);
            em.getTransaction().commit();
            System.out.println("Operación de eliminación terminada correctamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar la cuenta bancaria", e);
        }
    }

    /**
     * Guarda una cuenta bancaria en la base de datos.
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(cuentaBancaria);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la cuenta bancaria", e);
        }
    }

    /**
     * Modifica una cuenta bancaria existente en la base de datos.
     *
     * @param cuentaBancaria La cuenta bancaria con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la modificación.
     */
    @Override
    public void modificarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(cuentaBancaria);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar cuenta bancaria", e);
        } finally {
            em.close();
        }
    }

    /**
     * Guarda una cuenta bancaria con sus relaciones (beneficiario y pagos).
     *
     * @param cuentaBancaria La cuenta bancaria a guardar.
     * @param beneficiario El beneficiario asociado a la cuenta bancaria.
     * @param pagos La lista de pagos asociados a la cuenta bancaria.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * guardado.
     */
    @Override
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaEntidad cuentaBancaria, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            cuentaBancaria.setBeneficiario(beneficiario);
            cuentaBancaria.setPagos(pagos);
            em.persist(cuentaBancaria);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la cuenta bancaria con relaciones", e);
        }
    }

    /**
     * Busca una cuenta bancaria en la base de datos basado en el objeto
     * cuentaBancaria proporcionado.
     *
     * @param cuentaBancaria La cuenta bancaria con el ID a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws PersistenciaException Si no se encuentra ninguna cuenta bancaria
     * con el ID especificado.
     */
    @Override
    public CuentaBancariaEntidad buscarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CuentaBancariaEntidad> criteria = cb.createQuery(CuentaBancariaEntidad.class);
        Root<CuentaBancariaEntidad> root = criteria.from(CuentaBancariaEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), cuentaBancaria.getId()));
        TypedQuery<CuentaBancariaEntidad> query = em.createQuery(criteria);
        CuentaBancariaEntidad cuentas;
        try {
            cuentas = (CuentaBancariaEntidad) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        }
        return cuentas;
    }

    /**
     * Busca una cuenta bancaria en la base de datos basado en su ID.
     *
     * @param idCuentaBancaria El ID de la cuenta bancaria a buscar.
     * @return La cuenta bancaria encontrada.
     * @throws PersistenciaException Si no se encuentra ninguna cuenta bancaria
     * con el ID especificado.
     */
    @Override
    public CuentaBancariaEntidad buscarCuentaBancariaPorId(Long idCuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CuentaBancariaEntidad> criteria = cb.createQuery(CuentaBancariaEntidad.class);
        Root<CuentaBancariaEntidad> root = criteria.from(CuentaBancariaEntidad.class);
        criteria.select(root).where(cb.equal(root.get("id"), idCuentaBancaria));
        TypedQuery<CuentaBancariaEntidad> query = em.createQuery(criteria);
        CuentaBancariaEntidad cuentaBancaria;
        try {
            cuentaBancaria = query.getSingleResult();
        } catch (NoResultException nre) {
            throw new PersistenciaException("Cuenta bancaria no encontrada con id: " + idCuentaBancaria);
        }
        return cuentaBancaria;
    }

    /**
     * Lista todas las cuentas bancarias asociadas a un beneficiario.
     *
     * @param idBeneficiario El ID del beneficiario cuyas cuentas se desean
     * listar.
     * @return Una lista de cuentas bancarias asociadas al beneficiario.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<CuentaBancariaEntidad> listaCuentasPorIdBeneficiario(Long idBeneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        List<CuentaBancariaEntidad> cuentasBancarias = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<CuentaBancariaEntidad> criteria = cb.createQuery(CuentaBancariaEntidad.class);
            Root<CuentaBancariaEntidad> root = criteria.from(CuentaBancariaEntidad.class);

            criteria.select(root).where(cb.equal(root.get("beneficiario").get("id"), idBeneficiario));

            TypedQuery<CuentaBancariaEntidad> query = em.createQuery(criteria);
            cuentasBancarias = query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todas las cuentas bancarias", e);
        } finally {
            em.close();
        }
        return cuentasBancarias;
    }

    @Override
    public List<CuentaBancariaEntidad> buscarCuentasBancarias(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CuentaBancariaEntidad> criteria = cb.createQuery(CuentaBancariaEntidad.class);
        Root<CuentaBancariaEntidad> root = criteria.from(CuentaBancariaEntidad.class);

        // Agregar condición para filtrar por idBeneficiario
        criteria.select(root).where(cb.equal(root.get("beneficiario"), beneficiario));

        TypedQuery<CuentaBancariaEntidad> query = em.createQuery(criteria);
        List<CuentaBancariaEntidad> cuentasBancarias;
        try {
            cuentasBancarias = query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar cuentas bancarias", e);
        } finally {
            em.close();
        }
        return cuentasBancarias;
    }

    @Override
    public List<CuentaBancariaEntidad> buscarCuentasBancarias() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
