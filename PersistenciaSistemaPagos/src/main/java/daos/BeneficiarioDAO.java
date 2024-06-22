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
import javax.persistence.PersistenceException;

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
}
