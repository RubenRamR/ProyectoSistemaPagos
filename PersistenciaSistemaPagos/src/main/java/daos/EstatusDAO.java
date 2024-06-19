/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.EstatusEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caarl
 */


public class EstatusDAO {

    public void guardarEstatus(EstatusEntidad estatus) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(estatus);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada exitosamente");
        entityManager.close();
        managerFactory.close();
    }

    public void modificarEstatus(Long id, EstatusEntidad estatus) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EstatusEntidad estatusExistente = entityManager.find(EstatusEntidad.class, id);
        estatusExistente.setNombre(estatus.getNombre());
        entityManager.persist(estatusExistente);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada correctamente");
        entityManager.close();
        managerFactory.close();
    }
}