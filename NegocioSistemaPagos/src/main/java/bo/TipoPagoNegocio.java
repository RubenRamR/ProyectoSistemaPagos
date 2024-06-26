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
import conexion.ConexionBD;
import daos.TipoPagoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rramirez
 */
public class TipoPagoNegocio implements ITipoPagoNegocio {

    private final ITipoPagoDAO tipoPagoDAO;
    private static final Logger LOGGER = Logger.getLogger(TipoPagoNegocio.class.getName());
    IConexionBD conexion;

    public TipoPagoNegocio() {
        this.conexion = new ConexionBD();
        this.tipoPagoDAO = new TipoPagoDAO(conexion);
    }

    @Override
    public void eliminarTipoPago(Long id) {
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

    public List<TipoPagoDTO> muestraTiposPago() throws NegocioException {
        try {
            List<TipoPagoEntidad> tiposPagoEntidad = tipoPagoDAO.buscarTodosTiposPago();

            List<TipoPagoDTO> tiposPagoDTO = new ArrayList<>();
            for (TipoPagoEntidad tipoPagoEntidad : tiposPagoEntidad) {
                tiposPagoDTO.add(convertirADTO(tipoPagoEntidad));
            }

            return tiposPagoDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de tipos de pago", e);
        }
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
        TipoPagoDTO tipoPagoDTO = new TipoPagoDTO();
        tipoPagoDTO.setId(tipoPago.getId());
        tipoPagoDTO.setNombre(tipoPago.getNombre());
        tipoPagoDTO.setNumMensualidades(tipoPago.getNumMensualidades());

        return tipoPagoDTO;
    }
}
