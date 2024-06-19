/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import daos.BeneficiarioDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaBeneficiarioDAO {
    public static void main(String[] args) {
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(); // Implementación concreta del DAO

        // Prueba de guardarBeneficiario
        BeneficiarioEntidad beneficiario = new BeneficiarioEntidad("Juan", "Pérez", "Gómez", "jperez", "contraseña", "ABC123", 1000.0f);
        beneficiarioDAO.guardarBeneficiario(beneficiario);

        // Prueba de modificarBeneficiario
        Long idBeneficiario = 1L; // ID del beneficiario a modificar
        BeneficiarioEntidad beneficiarioModificado = new BeneficiarioEntidad("Juan Carlos", "Pérez", "Gómez", "jperez", "nuevacontraseña", "ABC123", 2000.0f);
        beneficiarioDAO.modificarBeneficiario(idBeneficiario, beneficiarioModificado);

        // Prueba de guardarBeneficiarioConRelaciones
        List<CuentaBancariaEntidad> cuentas = new ArrayList<>();
        CuentaBancariaEntidad cuenta = new CuentaBancariaEntidad(1234567890L, "clave123", "Banco XYZ", false, beneficiario); // Crear una instancia de CuentaBancariaEntidad
        cuentas.add(cuenta);

        List<PagoEntidad> pagos = new ArrayList<>();
        PagoEntidad pago = new PagoEntidad(); // Crear una instancia de PagoEntidad
        pagos.add(pago);

        beneficiarioDAO.guardarBeneficiarioConRelaciones(beneficiarioModificado, cuentas, pagos);
    }
}
