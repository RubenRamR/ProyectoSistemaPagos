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
import daos.BeneficiarioDAO;
import daos.CuentaBancariaDAO;
import daos.PagoDAO;
import daos.TipoPagoDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.TipoPagoEntidad;
import interfaces.IBeneficiarioDAO;

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
    public void eliminarPago(Long id) throws NegocioException {
        try {
            PagoEntidad pagoExistente = pagoDAO.buscarPagoPorId(id);
            if (pagoExistente == null) {
                try {
                    throw new NegocioException("El pago con ID " + id + " no existe.");
                } catch (NegocioException ex) {
                    Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Cambiar la columna "eliminado" a true
            pagoExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            pagoDAO.guardarPago(pagoExistente);
        } catch (PersistenciaException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el pago.", ex);
            try {
                throw new NegocioException("Error al eliminar el pago.", ex);
            } catch (NegocioException ex1) {
                Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void guardarPago(PagoDTO pagoDTO) throws NegocioException {
        PagoEntidad pago = convertirADominio(pagoDTO);
        try {
            pagoDAO.guardarPago(pago);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PagoDTO buscarPagoPorId(Long id) throws NegocioException {
        PagoEntidad pago = null;
        try {
            pago = pagoDAO.buscarPagoPorId(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertirADTO(pago);
    }

    private PagoEntidad convertirADominio(PagoDTO pagoDTO) throws NegocioException {
        // Convert DTO to Entity
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(conexion);
        BeneficiarioEntidad beneficiario = null;

        TipoPagoDAO tipo = new TipoPagoDAO(conexion);
        TipoPagoEntidad tipoPago = null;

        try {
            beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(pagoDTO.getBeneficiario().getId());
            tipoPago = tipo.buscarTipoPagoPorId(pagoDTO.getTipoPago().getId());
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        PagoEntidad pago = new PagoEntidad(pagoDTO.getMonto(), pagoDTO.getComprobante(), pagoDTO.getFechaHora(), beneficiario, tipoPago, false);
        pago.setId(pagoDTO.getId());
        pago.setMonto(pagoDTO.getMonto());
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
