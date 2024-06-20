/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.PagoDTO;
import InterfacesNegocio.IPagoNegocio;
import excepciones.NegocioException;
import interfaces.IPagoDAO;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class PagoNegocio implements IPagoNegocio {

    private IPagoDAO PagoDAO;
    private static final Logger LOGGER = Logger.getLogger(PagoNegocio.class.getName());

    public PagoNegocio(IPagoDAO PagoDAO) {
        this.PagoDAO = PagoDAO;
    }

    @Override
    public void guardarPago(PagoDTO pago) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
