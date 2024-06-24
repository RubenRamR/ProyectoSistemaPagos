/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import static Utileria.Utilidades.RegresarOFFSETMySQL;
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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author caarl
 */
public class BeneficiarioDAO implements IBeneficiarioDAO {

    final IConexionBD conexion;

    public BeneficiarioDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
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

    @Override
    public void guardarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.persist(beneficiario);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el beneficiario", e);
        }
    }

    @Override
    public void modificarBeneficiario(Long id, BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            BeneficiarioEntidad beneficiarioExistente = em.find(BeneficiarioEntidad.class, id);
            if (beneficiarioExistente == null)
            {
                throw new PersistenciaException("El beneficiario con ID " + id + " no existe");
            }
            beneficiarioExistente.setNombres(beneficiario.getNombres());
            beneficiarioExistente.setApellidoPaterno(beneficiario.getApellidoPaterno());
            beneficiarioExistente.setApellidoMaterno(beneficiario.getApellidoMaterno());
            beneficiarioExistente.setUsuario(beneficiario.getUsuario());
            beneficiarioExistente.setContrasena(beneficiario.getContrasena());
            beneficiarioExistente.setClaveContrato(beneficiario.getClaveContrato());
            beneficiarioExistente.setSaldo(beneficiario.getSaldo());
            
            em.merge(beneficiarioExistente);
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar el beneficiario", e);
        }
    }

    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            beneficiario.setCuentas(cuentas);
            beneficiario.setPagos(pagos);
            em.persist(beneficiario);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el beneficiario con relaciones", e);
        }
    }

    @Override
    public BeneficiarioEntidad buscarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
        Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);
        criteria.select(root).where(cb.equal(root.get("idBeneficiario"), beneficiario.getId()));
        TypedQuery<BeneficiarioEntidad> query = em.createQuery(criteria);
        BeneficiarioEntidad beneficiarios;
        try {
            beneficiarios = (BeneficiarioEntidad) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        }
        return beneficiarios;
    }

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
    
    @Override
    public BeneficiarioEntidad loginBeneficiario(String usuario, String contrasena) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<BeneficiarioEntidad> criteria = cb.createQuery(BeneficiarioEntidad.class);
            Root<BeneficiarioEntidad> root = criteria.from(BeneficiarioEntidad.class);

            // Create the conditions (predicates)
            Predicate condition1 = cb.equal(root.get("usuario"), usuario);
            Predicate condition2 = cb.equal(root.get("contrasena"), contrasena);

            // Combine conditions with AND
            criteria.select(root).where(cb.and(condition1, condition2));

            // Execute the query
            List<BeneficiarioEntidad> resultList = em.createQuery(criteria).getResultList();

            // Check if a result is found
            if (resultList.isEmpty()) {
                throw new PersistenciaException("No se encontró el usuario");
            }  else {
                return resultList.get(0); // Return the first (and presumably only) result
            }
        } finally {
            em.close();
        }
    }
    
    
    
}
