/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class BeneficiarioNegocio implements IBeneficiarioNegocio {

    private IBeneficiarioDAO beneficiarioDAO;
    IConexionBD conexion;
    private static final Logger LOGGER = Logger.getLogger(BeneficiarioNegocio.class.getName());

    public BeneficiarioNegocio() {
        this.conexion = new ConexionBD();
        this.beneficiarioDAO = new BeneficiarioDAO(conexion);
    }

    @Override
    public void guardarBeneficiario(BeneficiarioDTO beneficiarioDTO) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiario = new BeneficiarioEntidad(
                    beneficiarioDTO.getNombres(),
                    beneficiarioDTO.getApellidoPaterno(),
                    beneficiarioDTO.getApellidoMaterno(),
                    beneficiarioDTO.getUsuario(),
                    beneficiarioDTO.getContrasena(),
                    beneficiarioDTO.getClaveContrato(),
                    beneficiarioDTO.getSaldo()
            );
            beneficiarioDAO.guardarBeneficiario(beneficiario);

        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void modificarBeneficiario(Long id, BeneficiarioDTO beneficiario) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
