/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caarl
 */


public class AbonoDAO {
    public void guardarAbono(AbonoEntidad abono) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(abono);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada exitosamente");
        entityManager.close();
        managerFactory.close();
    }

    public void modificarAbono(Long id, AbonoEntidad abono) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AbonoEntidad abonoExistente = entityManager.find(AbonoEntidad.class, id);
        abonoExistente.setFechaHora(abono.getFechaHora());
        abonoExistente.setMonto(abono.getMonto());
        abonoExistente.setPago(abono.getPago());
        entityManager.persist(abonoExistente);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada correctamente");
        entityManager.close();
        managerFactory.close();
    }

    public void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        abono.setPago(pago);
        entityManager.persist(abono);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada exitosamente");
        entityManager.close();
        managerFactory.close();
    }
}