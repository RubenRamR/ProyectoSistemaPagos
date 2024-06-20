/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.TipoPagoDTO;
import InterfacesNegocio.ITipoPagoNegocio;
import excepciones.NegocioException;
import interfaces.ITipoPagoDAO;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class TipoPagoNegocio implements ITipoPagoNegocio {

    private ITipoPagoDAO TipoPagoDAO;
    private static final Logger LOGGER = Logger.getLogger(TipoPagoNegocio.class.getName());

    public TipoPagoNegocio(ITipoPagoDAO TipoPagoDAO) {
        this.TipoPagoDAO = TipoPagoDAO;
    }

    @Override
    public void guardarTipoPago(TipoPagoDTO tipo) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarBeneficiario(Long id, TipoPagoDTO tipo) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
