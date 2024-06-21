/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaBeneficiarioDAO {
    
    public static void main(String[] args) throws PersistenciaException {
        
        IConexionBD conexion = new ConexionBD();
        
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(conexion);
//
//        // Prueba de guardarBeneficiario
//        BeneficiarioEntidad beneficiario = new BeneficiarioEntidad("Juan", "Pérez", "Gómez", "jperez", "contraseña", "ABC123", 1000.0f);
//        beneficiarioDAO.guardarBeneficiario(beneficiario);

        System.out.println(beneficiarioDAO.buscarBeneficiarioPorId(1l));
        
    }
}
