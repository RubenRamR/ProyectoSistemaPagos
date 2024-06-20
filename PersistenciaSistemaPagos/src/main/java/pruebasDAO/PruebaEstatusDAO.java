/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.EstatusDAO;
import entidades.EstatusEntidad;
import interfaces.IConexionBD;

/**
 *
 * @author caarl
 */
public class PruebaEstatusDAO {
    public static void main(String[] args) {
        
        IConexionBD conexion = new ConexionBD();
        
        EstatusDAO estatusDAO = new EstatusDAO(conexion); // Implementación concreta del DAO

//        // Prueba de guardarEstatus
//        EstatusEntidad estatus = new EstatusEntidad("Pendiente");
//        estatusDAO.guardarEstatus(estatus);
//
//        // Prueba de modificarEstatus
//        Long idEstatus = 1L; // ID del estatus a modificar
//        EstatusEntidad estatusModificado = new EstatusEntidad("Pagado");
//        estatusDAO.modificarEstatus(idEstatus, estatusModificado);
    }
}
