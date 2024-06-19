/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prueba;

import entidades.Beneficiario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rramirez
 */
public class PersistenciaSistemaPagos {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionBD");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNombres("Juan");
        beneficiario.setApellidoPaterno("Perez");
        beneficiario.setApellidoMaterno("Lopez");
        beneficiario.setUsuario("jperez");
        beneficiario.setContrasena("password");
        beneficiario.setClaveContrato("ABC123");
        beneficiario.setSaldo(1000);

        em.persist(beneficiario);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
