/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.AbonoDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IAbonoNegocio;
import excepciones.NegocioException;
import interfaces.IAbonoDAO;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class AbonoNegocio implements IAbonoNegocio {

    private IAbonoDAO abonoDAO;
    private static final Logger LOGGER = Logger.getLogger(AbonoNegocio.class.getName());

    public AbonoNegocio(IAbonoDAO abonoDAO) {
        this.abonoDAO = abonoDAO;
    }

    @Override
    public void guardarAbono(AbonoDTO abono) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarAbono(Long id, AbonoDTO abono) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarAbonoConRelacion(AbonoDTO abono, PagoDTO pago) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
