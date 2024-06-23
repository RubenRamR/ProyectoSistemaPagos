/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.TipoPagoDTO;
import entidades.TipoPagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITipoPagoDAO;
import java.util.logging.Level;

import java.util.logging.Logger;
import InterfacesNegocio.ITipoPagoNegocio;


/**
 *
 * @author rramirez
 */
public class TipoPagoNegocio implements ITipoPagoNegocio {

    private final ITipoPagoDAO tipoPagoDAO;
    private static final Logger LOGGER = Logger.getLogger(TipoPagoNegocio.class.getName());
    IConexionBD conexion;
    
    @Override
public void eliminarTipoPago(Long id)  {
    try {
        // Buscar el tipo de pago existente por su ID
        TipoPagoEntidad tipoPagoExistente = tipoPagoDAO.buscarTipoPagoPorId(id);
        if (tipoPagoExistente == null) {
            try {
                throw new NegocioException("El tipo de pago con ID " + id + " no existe.");
            } catch (NegocioException ex) {
                Logger.getLogger(TipoPagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Cambiar la columna "eliminado" a true
        tipoPagoExistente.setEliminado(true);

        // Guardar los cambios en la base de datos
        tipoPagoDAO.guardarTipoPago(tipoPagoExistente);
    } catch (PersistenciaException ex) {
        try {
            LOGGER.log(Level.SEVERE, "Error al eliminar el tipo de pago.", ex);
            throw new NegocioException("Error al eliminar el tipo de pago.", ex);
        } catch (NegocioException ex1) {
            Logger.getLogger(TipoPagoNegocio.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}


    public TipoPagoNegocio(IConexionBD conexion, ITipoPagoDAO tipoPagoDAO) {
        this.conexion = conexion;
        this.tipoPagoDAO = tipoPagoDAO;
    }

    @Override
    public void guardarTipoPago(TipoPagoDTO tipoPagoDTO) throws PersistenciaException {
        TipoPagoEntidad tipoPago = convertirADominio(tipoPagoDTO);
        tipoPagoDAO.guardarTipoPago(tipoPago);
    }

    @Override
    public void modificarTipoPago(Long id, TipoPagoDTO tipoPagoDTO) throws PersistenciaException {
        TipoPagoEntidad tipoPago = convertirADominio(tipoPagoDTO);
        tipoPagoDAO.modificarTipoPago(id, tipoPago);
    }

    @Override
    public TipoPagoDTO buscarTipoPagoPorId(Long id) throws PersistenciaException {
        TipoPagoEntidad tipoPago = tipoPagoDAO.buscarTipoPagoPorId(id);
        return convertirADTO(tipoPago);
    }



    private TipoPagoEntidad convertirADominio(TipoPagoDTO tipoPagoDTO) {
        // Convert DTO to Entity
        TipoPagoEntidad tipoPago = new TipoPagoEntidad();
        tipoPago.setId(tipoPagoDTO.getId());
        tipoPago.setNombre(tipoPagoDTO.getNombre());
        // Set other fields
        return tipoPago;
    }

    private TipoPagoDTO convertirADTO(TipoPagoEntidad tipoPago) {
        // Convert Entity to DTO
        TipoPagoDTO tipoPagoDTO = new TipoPagoDTO();
        tipoPagoDTO.setId(tipoPago.getId());
        tipoPagoDTO.setNombre(tipoPago.getNombre());
        // Set other fields
        return tipoPagoDTO;
    }
}
