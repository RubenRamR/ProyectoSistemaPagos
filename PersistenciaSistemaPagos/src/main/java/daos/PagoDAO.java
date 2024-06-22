/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IPagoDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Chris
 */
public class PagoDAO implements IPagoDAO {

    final IConexionBD conexion;

    public PagoDAO(IConexionBD conexion) {
        this.conexion = conexion;
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
            throw new PersistenciaException("Error al guardar el beneficiario", e);
        }
    }

}
