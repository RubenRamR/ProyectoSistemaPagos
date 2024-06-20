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
import javax.persistence.PersistenceException;

/**
 *
 * @author caarl
 */
public class CuentaBancariaDAO implements ICuentaBancariaDAO {

    final IConexionBD conexion;

    public CuentaBancariaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(cuentaBancaria);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la cuenta bancaria", e);
        }
    }

    @Override
    public void modificarCuentaBancaria(Long id, CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            CuentaBancariaEntidad cuentaBancariaExistente = em.find(CuentaBancariaEntidad.class, id);
            if (cuentaBancariaExistente == null) {
                throw new PersistenciaException("La cuenta bancaria con ID " + id + " no existe");
            }
            cuentaBancariaExistente.setNumeroCuenta(cuentaBancaria.getNumeroCuenta());
            cuentaBancariaExistente.setClave(cuentaBancaria.getClave());
            cuentaBancariaExistente.setBanco(cuentaBancaria.getBanco());
            cuentaBancariaExistente.setEliminado(cuentaBancaria.isEliminado());
            cuentaBancariaExistente.setBeneficiario(cuentaBancaria.getBeneficiario());
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar la cuenta bancaria", e);
        }
    }

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
}
