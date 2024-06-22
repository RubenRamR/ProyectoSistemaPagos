/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITipoPagoDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Chris
 */
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
            throw new PersistenciaException("Error al guardar el beneficiario", e);
        }
    }

    @Override
    public void modificarBeneficiario(Long id, TipoPagoEntidad tipo) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try
        {
            em.getTransaction().begin();
            TipoPagoEntidad tipoPago = em.find(TipoPagoEntidad.class, id);
            if (tipoPago == null)
            {
                throw new PersistenciaException("La cuenta bancaria con ID " + id + " no existe");
            }
            tipoPago.setNombre(tipoPago.getNombre());
            tipoPago.setNumMensualidades(tipoPago.getNumMensualidades());
            tipoPago.setPagos(tipoPago.getPagos());

            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar la cuenta bancaria", e);
        }
    }

}
