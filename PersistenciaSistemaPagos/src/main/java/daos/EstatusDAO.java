/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.EstatusEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstatusDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author caarl
 */
public class EstatusDAO implements IEstatusDAO {

    final IConexionBD conexion;

    public EstatusDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardarEstatus(EstatusEntidad estatus) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(estatus);
            em.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el estatus", e);
        }
    }

    @Override
    public void modificarEstatus(Long id, EstatusEntidad estatus) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            EstatusEntidad estatusExistente = em.find(EstatusEntidad.class, id);
            if (estatusExistente == null) {
                throw new PersistenciaException("El estatus con ID " + id + " no existe");
            }
            estatusExistente.setNombre(estatus.getNombre());
            em.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar el estatus", e);
        }
    }
}
