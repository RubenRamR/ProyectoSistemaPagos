/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasDAO;

import conexion.ConexionBD;
import daos.EstatusDAO;
import entidades.EstatusEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.List;

/**
 *
 * @author caarl
 */
public class PruebaEstatusDAO {
    public static void main(String[] args) throws PersistenciaException {
        
        IConexionBD conexion = new ConexionBD();
        EstatusDAO estatusDAO = new EstatusDAO(conexion);

        // Prueba de buscar todos los estatus
        List<EstatusEntidad> todosEstatus = estatusDAO.buscarTodosLosEstatus();
        System.out.println("Todos los estatus:");
        for (EstatusEntidad estatus : todosEstatus) {
            System.out.println(estatus);
        }

        // Prueba de buscar estatus por ID
        Long idEstatusBuscar = 1L;
        EstatusEntidad estatusBuscado = estatusDAO.buscarEstatusPorId(idEstatusBuscar);
        System.out.println("\nEstatus buscado por ID " + idEstatusBuscar + ": " + estatusBuscado);

        
    }
}
