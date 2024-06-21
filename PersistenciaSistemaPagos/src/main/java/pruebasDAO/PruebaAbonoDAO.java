/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.AbonoDAO;
import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.Calendar;

/**
 *
 * @author caarl
 */
public class PruebaAbonoDAO {

    public static void main(String[] args) throws PersistenciaException {

        IConexionBD conexion = new ConexionBD();
        AbonoDAO abonoDAO = new AbonoDAO(conexion);

//        // Prueba de guardarAbono
//        Calendar fechaHora = Calendar.getInstance();
//        PagoEntidad pago = new PagoEntidad(); // Crear una instancia de PagoEntidad
//        AbonoEntidad abono = new AbonoEntidad(fechaHora, 500.0f, pago);
//        abonoDAO.guardarAbono(abono);
//
//        // Prueba de modificarAbono
//        Long idAbono = 1L; // ID del abono a modificar
//        AbonoEntidad abonoModificado = new AbonoEntidad(fechaHora, 800.0f, pago);
//        abonoDAO.modificarAbono(idAbono, abonoModificado);
//
//        // Prueba de guardarAbonoConRelacion
//        abonoDAO.guardarAbonoConRelacion(abonoModificado, pago);

        System.out.println(abonoDAO.buscarAbonoPorId(1L));
        System.out.println(abonoDAO.buscarAbonos());

    }
}
