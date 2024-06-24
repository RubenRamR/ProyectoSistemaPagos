/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.PagoDAO;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaPagoDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexion = new ConexionBD();
        PagoDAO pagoDAO = new PagoDAO(conexion);

        // Prueba de buscar todos los pagos
//        List<PagoEntidad> pagos = pagoDAO.buscarTodosPagos();
//        System.out.println("Todos los pagos:");
//        for (PagoEntidad pago : pagos) {
//            System.out.println(pago);
//        }

        // Prueba de buscar pago por ID
//        Long idPagoBuscar = 1L;
//        PagoEntidad pagoBuscado = pagoDAO.buscarPagoPorId(idPagoBuscar);
//        System.out.println("\nPago buscado por ID " + idPagoBuscar + ": " + pagoBuscado);

        // Prueba de buscar pagos por beneficiario
//        Long idBeneficiario = 1L;
//        List<PagoEntidad> pagosPorBeneficiario = pagoDAO.buscarPagosPorBeneficiario(idBeneficiario);
//        System.out.println("\nPagos del beneficiario con ID " + idBeneficiario + ":");
//        for (PagoEntidad pago : pagosPorBeneficiario) {
//            System.out.println(pago);
//        }

        // Prueba de buscar pagos por rango de fechas
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.set(2024, Calendar.JUNE, 20);
        Calendar fechaFin = Calendar.getInstance();
        fechaFin.set(2024, Calendar.JUNE, 22);
        List<PagoEntidad> pagosPorFecha = pagoDAO.buscarPagosPorRangoFechas(fechaInicio, fechaFin);
        System.out.println("\nPagos entre " + fechaInicio.getTime() + " y " + fechaFin.getTime() + ":");
        for (PagoEntidad pago : pagosPorFecha) {
            System.out.println(pago);
        }

        // Prueba de buscar pagos por tipo de pago
//        Long idTipoPago = 1L;
//        List<PagoEntidad> pagosPorTipo = pagoDAO.buscarPagosPorTipoPago(idTipoPago);
//        System.out.println("\nPagos del tipo de pago con ID " + idTipoPago + ":");
//        for (PagoEntidad pago : pagosPorTipo) {
//            System.out.println(pago);
//        }
    }
}
