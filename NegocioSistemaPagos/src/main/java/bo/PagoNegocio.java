/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.PagoDTO;
import InterfacesNegocio.IPagoBO;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IPagoDAO;

import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class PagoNegocio implements IPagoBO {

    private final IPagoDAO pagoDAO;
    private static final Logger LOGGER = Logger.getLogger(PagoNegocio.class.getName());
    IConexionBD conexion;

    public PagoNegocio(IConexionBD conexion, IPagoDAO pagoDAO) {
        this.conexion = conexion;
        this.pagoDAO = pagoDAO;
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
        PagoEntidad pago = new PagoEntidad();
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
