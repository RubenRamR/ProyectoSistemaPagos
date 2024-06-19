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


public class CuentaBancariaDAO {

    public void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cuentaBancaria);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada exitosamente");
        entityManager.close();
        managerFactory.close();
    }

    public void modificarCuentaBancaria(Long id, CuentaBancariaEntidad cuentaBancaria) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CuentaBancariaEntidad cuentaBancariaExistente = entityManager.find(CuentaBancariaEntidad.class, id);
        cuentaBancariaExistente.setNumeroCuenta(cuentaBancaria.getNumeroCuenta());
        cuentaBancariaExistente.setClave(cuentaBancaria.getClave());
        cuentaBancariaExistente.setBanco(cuentaBancaria.getBanco());
        cuentaBancariaExistente.setEliminado(cuentaBancaria.isEliminado());
        cuentaBancariaExistente.setBeneficiario(cuentaBancaria.getBeneficiario());
        entityManager.persist(cuentaBancariaExistente);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada correctamente");
        entityManager.close();
        managerFactory.close();
    }

    public void guardarCuentaBancariaConRelaciones(CuentaBancariaEntidad cuentaBancaria, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        cuentaBancaria.setBeneficiario(beneficiario);
        cuentaBancaria.setPagos(pagos);
        entityManager.persist(cuentaBancaria);
        entityManager.getTransaction().commit();
        System.out.println("Operación terminada exitosamente");
        entityManager.close();
        managerFactory.close();
    }
}