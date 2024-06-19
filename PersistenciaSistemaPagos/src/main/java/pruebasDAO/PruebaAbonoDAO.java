/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import daos.AbonoDAO;
import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import java.util.Calendar;

/**
 *
 * @author caarl
 */
public class PruebaAbonoDAO {
    public static void main(String[] args) {
        AbonoDAO abonoDAO = new AbonoDAO(); // Implementación concreta del DAO

        // Prueba de guardarAbono
        Calendar fechaHora = Calendar.getInstance();
        PagoEntidad pago = new PagoEntidad(); // Crear una instancia de PagoEntidad
        AbonoEntidad abono = new AbonoEntidad(fechaHora, 500.0f, pago);
        abonoDAO.guardarAbono(abono);

        // Prueba de modificarAbono
        Long idAbono = 1L; // ID del abono a modificar
        AbonoEntidad abonoModificado = new AbonoEntidad(fechaHora, 800.0f, pago);
        abonoDAO.modificarAbono(idAbono, abonoModificado);

        // Prueba de guardarAbonoConRelacion
        abonoDAO.guardarAbonoConRelacion(abonoModificado, pago);
    }
}
