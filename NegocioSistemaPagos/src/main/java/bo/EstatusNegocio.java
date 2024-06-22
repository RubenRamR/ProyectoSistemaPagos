/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.EstatusDTO;
import InterfacesNegocio.IEstatusNegocio;
import excepciones.NegocioException;
import interfaces.IEstatusDAO;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class EstatusNegocio implements IEstatusNegocio {

    private IEstatusDAO estatusDAO;
    private static final Logger LOGGER = Logger.getLogger(EstatusNegocio.class.getName());

    public EstatusNegocio(IEstatusDAO estatusDAO) {
        this.estatusDAO = estatusDAO;
    }

    @Override
    public void guardarEstatus(EstatusDTO estatus) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarEstatus(Long id, EstatusDTO estatus) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
