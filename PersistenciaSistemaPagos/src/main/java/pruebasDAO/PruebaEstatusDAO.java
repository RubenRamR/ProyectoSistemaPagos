/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import daos.EstatusDAO;
import entidades.EstatusEntidad;

/**
 *
 * @author caarl
 */
public class PruebaEstatusDAO {
    public static void main(String[] args) {
        EstatusDAO estatusDAO = new EstatusDAO(); // Implementación concreta del DAO

        // Prueba de guardarEstatus
        EstatusEntidad estatus = new EstatusEntidad("Pendiente");
        estatusDAO.guardarEstatus(estatus);

        // Prueba de modificarEstatus
        Long idEstatus = 1L; // ID del estatus a modificar
        EstatusEntidad estatusModificado = new EstatusEntidad("Pagado");
        estatusDAO.modificarEstatus(idEstatus, estatusModificado);
    }
}
