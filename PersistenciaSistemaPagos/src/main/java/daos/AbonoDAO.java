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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

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
    public void guardarAbono(AbonoEntidad abono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            em.persist(abono);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar el abono", e);
        }
    }

    @Override
    public void modificarAbono(Long id, AbonoEntidad abono) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            AbonoEntidad abonoExistente = em.find(AbonoEntidad.class, id);
            if (abonoExistente == null)
            {
                throw new PersistenciaException("El abono con ID " + id + " no existe");
            }
            abonoExistente.setFechaHora(abono.getFechaHora());
            abonoExistente.setMonto(abono.getMonto());
            abonoExistente.setPago(abono.getPago());
            em.persist(abonoExistente);
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e)
        {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al modificar el abono", e);
        }
    }

    @Override
    public void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            abono.setPago(pago);
            em.persist(abono);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e)
        {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar el abono con relación al pago", e);
        }
    }
}
