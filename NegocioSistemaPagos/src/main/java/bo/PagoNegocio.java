/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.PagoDTO;
import entidades.PagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IPagoDAO;
import java.util.logging.Level;

import java.util.logging.Logger;
import InterfacesNegocio.IPagoNegocio;
import conexion.ConexionBD;
import daos.PagoDAO;

/**
 *
 * @author rramirez
 */
public class PagoNegocio implements IPagoNegocio {

    private final IPagoDAO pagoDAO;
    private static final Logger LOGGER = Logger.getLogger(PagoNegocio.class.getName());
    IConexionBD conexion;

    public PagoNegocio() {
        this.conexion = new ConexionBD();
        this.pagoDAO = new PagoDAO(conexion);
    }

    @Override
    public void eliminarPago(Long id) {
        try
        {
            // Buscar el pago existente por su ID
            PagoEntidad pagoExistente = pagoDAO.buscarPagoPorId(id);
            if (pagoExistente == null)
            {
                try
                {
                    throw new NegocioException("El pago con ID " + id + " no existe.");
                } catch (NegocioException ex)
                {
                    Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Cambiar la columna "eliminado" a true
            pagoExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            pagoDAO.guardarPago(pagoExistente);
        } catch (PersistenciaException ex)
        {
            LOGGER.log(Level.SEVERE, "Error al eliminar el pago.", ex);
            try
            {
                throw new NegocioException("Error al eliminar el pago.", ex);
            } catch (NegocioException ex1)
            {
                Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void guardarPago(PagoDTO pagoDTO) throws PersistenciaException {
        PagoEntidad pago = convertirADominio(pagoDTO);
        pagoDAO.guardarPago(pago);
    }

    @Override
    public PagoDTO buscarPagoPorId(Long id) throws PersistenciaException {
        PagoEntidad pago = pagoDAO.buscarPagoPorId(id);
        return convertirADTO(pago);
    }

    private PagoEntidad convertirADominio(PagoDTO pagoDTO) {
        // Convert DTO to Entity
        PagoEntidad pago = new PagoEntidad(pagoDTO.getMonto(), pagoDTO.getComprobante(), pagoDTO.getFechaHora());
        pago.setId(pagoDTO.getId());
        pago.setMonto(pagoDTO.getMonto());
        // Set other fields
        return pago;
    }

    private PagoDTO convertirADTO(PagoEntidad pago) {
        // Convert Entity to DTO
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setId(pago.getId());
        pagoDTO.setMonto(pago.getMonto());
        // Set other fields
        return pagoDTO;
    }
}
