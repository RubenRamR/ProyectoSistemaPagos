/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.ICuentaBancariaNegocio;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import daos.CuentaBancariaDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaBancariaDAO;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class CuentaBancariaNegocio implements ICuentaBancariaNegocio {

    private ICuentaBancariaDAO cuentaBancariaDAO;
    private IBeneficiarioDAO beneficiarioDAO;
    private static final Logger LOGGER = Logger.getLogger(CuentaBancariaNegocio.class.getName());
    IConexionBD conexion;

    public CuentaBancariaNegocio(ICuentaBancariaDAO cuentaBancariaDAO) {
        this.cuentaBancariaDAO = new CuentaBancariaDAO(conexion);
        this.conexion = new ConexionBD();
    }

    @Override
    public void guardarCuentaBancaria(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {
        try {
            beneficiarioDAO = new BeneficiarioDAO(conexion);
            BeneficiarioEntidad beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(cuentaBancariaDTO.getBeneficiario().getId());
            if (beneficiario == null) {
                throw new NegocioException("Beneficiario no encontrado con id: " + cuentaBancariaDTO.getBeneficiario().getId());
            }

            CuentaBancariaEntidad cuentaBancaria = new CuentaBancariaEntidad(
                    cuentaBancariaDTO.getNumeroCuenta(),
                    cuentaBancariaDTO.getClave(),
                    cuentaBancariaDTO.getBanco(),
                    cuentaBancariaDTO.isEliminado(),
                    beneficiario
            );

            cuentaBancariaDAO.guardarCuentaBancaria(cuentaBancaria);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al guardar la cuenta bancaria", ex);
        }

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
