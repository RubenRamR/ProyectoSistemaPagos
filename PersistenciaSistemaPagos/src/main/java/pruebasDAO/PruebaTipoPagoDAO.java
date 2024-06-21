/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.TipoPagoDAO;
import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaTipoPagoDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
      
        IConexionBD conexion = new ConexionBD();
        TipoPagoDAO tipoPagoDAO = new TipoPagoDAO(conexion);

        // Prueba de buscar todos los tipos de pago
        List<TipoPagoEntidad> tiposPago = tipoPagoDAO.buscarTodosTiposPago();
        System.out.println("Todos los tipos de pago:");
        for (TipoPagoEntidad tipoPago : tiposPago) {
            System.out.println(tipoPago);
        }

        // Prueba de buscar tipo de pago por ID
        Long idTipoPagoBuscar = 1L;
        TipoPagoEntidad tipoPagoBuscado = tipoPagoDAO.buscarTipoPagoPorId(idTipoPagoBuscar);
        System.out.println("\nTipo de pago buscado por ID " + idTipoPagoBuscar + ": " + tipoPagoBuscado);

        // Prueba de buscar tipos de pago por nombre
        String nombreBuscar = "Mensualidad";
        List<TipoPagoEntidad> tiposPagoPorNombre = tipoPagoDAO.buscarTiposPagoPorNombre(nombreBuscar);
        System.out.println("\nTipos de pago con nombre '" + nombreBuscar + "':");
        for (TipoPagoEntidad tipoPago : tiposPagoPorNombre) {
            System.out.println(tipoPago);
        }
    }
}
    

