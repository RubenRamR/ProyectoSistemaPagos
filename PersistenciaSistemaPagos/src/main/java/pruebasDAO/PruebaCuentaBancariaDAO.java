/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import daos.CuentaBancariaDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaCuentaBancariaDAO {
    public static void main(String[] args) {
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO(); // Implementación concreta del DAO

        // Prueba de guardarCuentaBancaria
        BeneficiarioEntidad beneficiario = new BeneficiarioEntidad(); // Crear una instancia de BeneficiarioEntidad
        CuentaBancariaEntidad cuentaBancaria = new CuentaBancariaEntidad(1234567890L, "clave123", "Banco XYZ", false, beneficiario);
        cuentaBancariaDAO.guardarCuentaBancaria(cuentaBancaria);

        // Prueba de modificarCuentaBancaria
        Long idCuentaBancaria = 1L; // ID de la cuenta bancaria a modificar
        CuentaBancariaEntidad cuentaBancariaModificada = new CuentaBancariaEntidad(9876543210L, "nuevaclave", "Banco ABC", true, beneficiario);
        cuentaBancariaDAO.modificarCuentaBancaria(idCuentaBancaria, cuentaBancariaModificada);

        // Prueba de guardarCuentaBancariaConRelaciones
        List<PagoEntidad> pagos = new ArrayList<>();
        PagoEntidad pago = new PagoEntidad(); // Crear una instancia de PagoEntidad
        pagos.add(pago);

        cuentaBancariaDAO.guardarCuentaBancariaConRelaciones(cuentaBancariaModificada, beneficiario, pagos);
    }
}