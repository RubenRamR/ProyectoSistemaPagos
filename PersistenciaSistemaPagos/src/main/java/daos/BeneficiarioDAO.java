/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caarl
 */


    public class BeneficiarioDAO {
        public void guardarBeneficiario(BeneficiarioEntidad beneficiario) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(beneficiario);
            entityManager.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
            entityManager.close();
            managerFactory.close();
        }

        public void modificarBeneficiario(Long id, BeneficiarioEntidad beneficiario) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            BeneficiarioEntidad beneficiarioExistente = entityManager.find(BeneficiarioEntidad.class, id);
            beneficiarioExistente.setNombres(beneficiario.getNombres());
            beneficiarioExistente.setApellidoPaterno(beneficiario.getApellidoPaterno());
            beneficiarioExistente.setApellidoMaterno(beneficiario.getApellidoMaterno());
            beneficiarioExistente.setUsuario(beneficiario.getUsuario());
            beneficiarioExistente.setContrasena(beneficiario.getContrasena());
            beneficiarioExistente.setClaveContrato(beneficiario.getClaveContrato());
            beneficiarioExistente.setSaldo(beneficiario.getSaldo());
            entityManager.persist(beneficiarioExistente);
            entityManager.getTransaction().commit();
            System.out.println("Operación terminada correctamente");
            entityManager.close();
            managerFactory.close();
        }

        public void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            beneficiario.setCuentas(cuentas);
            beneficiario.setPagos(pagos);
            entityManager.persist(beneficiario);
            entityManager.getTransaction().commit();
            System.out.println("Operación terminada exitosamente");
            entityManager.close();
            managerFactory.close();
        }
    }