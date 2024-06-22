/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.ICuentaBancariaNegocio;
import excepciones.NegocioException;
import interfaces.ICuentaBancariaDAO;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class CuentaBancariaNegocio implements ICuentaBancariaNegocio {

    private ICuentaBancariaDAO cuentaBancariaDAO;
    private static final Logger LOGGER = Logger.getLogger(CuentaBancariaNegocio.class.getName());

    public CuentaBancariaNegocio(ICuentaBancariaDAO cuentaBancariaDAO) {
        this.cuentaBancariaDAO = cuentaBancariaDAO;
    }

    @Override
    public void guardarCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarCuentaBancaria(Long id, CuentaBancariaDTO cuentaBancaria) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaDTO cuentaBancaria, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
