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
    try {
        // Buscar el beneficiario existente por su ID
        BeneficiarioEntidad beneficiarioExistente = beneficiarioDAO.buscarBeneficiarioPorId(id);
        if (beneficiarioExistente == null) {
            throw new NegocioException("El beneficiario con ID " + id + " no existe.");
        }

        // Actualizar los valores del beneficiario con los proporcionados en el DTO
        beneficiarioExistente.setNombres(beneficiario.getNombres());
        beneficiarioExistente.setApellidoPaterno(beneficiario.getApellidoPaterno());
        beneficiarioExistente.setApellidoMaterno(beneficiario.getApellidoMaterno());
        beneficiarioExistente.setUsuario(beneficiario.getUsuario());
        beneficiarioExistente.setContrasena(beneficiario.getContrasena());
        beneficiarioExistente.setClaveContrato(beneficiario.getClaveContrato());
        beneficiarioExistente.setSaldo(beneficiario.getSaldo());

        // Guardar los cambios en la base de datos
        beneficiarioDAO.guardarBeneficiario(beneficiarioExistente);
    } catch (PersistenciaException ex) {
        Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        throw new NegocioException("Error al modificar el beneficiario.", ex);
    }


    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

    
   @Override
public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException {
    try {
        // Crear una instancia de BeneficiarioEntidad con los datos del DTO
        BeneficiarioEntidad beneficiarioEntidad = new BeneficiarioEntidad(
            beneficiario.getNombres(),
            beneficiario.getApellidoPaterno(),
            beneficiario.getApellidoMaterno(),
            beneficiario.getUsuario(),
            beneficiario.getContrasena(),
            beneficiario.getClaveContrato(),
            beneficiario.getSaldo()
        );

        // Guardar el beneficiario en la base de datos
        beneficiarioDAO.guardarBeneficiario(beneficiarioEntidad);
    } catch (PersistenciaException ex) {
        Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        throw new NegocioException("Error al guardar el beneficiario con relaciones.", ex);
    }
}
}

