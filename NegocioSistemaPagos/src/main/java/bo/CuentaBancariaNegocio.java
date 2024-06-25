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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

    public CuentaBancariaNegocio() {
        this.conexion = new ConexionBD();
        this.cuentaBancariaDAO = new CuentaBancariaDAO(conexion);

    }

    @Override
    public void eliminarCuentaBancaria(Long id) throws NegocioException {
        try {
            // Buscar la cuenta bancaria existente por su ID
            CuentaBancariaEntidad cuentaExistente = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);
            if (cuentaExistente == null) {
                throw new NegocioException("La cuenta bancaria con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            cuentaExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            cuentaBancariaDAO.guardarCuentaBancaria(cuentaExistente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al eliminar la cuenta bancaria.", ex);
        }
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

    try {
        // Buscar la cuenta bancaria existente por su ID
        CuentaBancariaEntidad cuentaExistente = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);
        if (cuentaExistente == null) {
            throw new NegocioException("La cuenta bancaria con ID " + id + " no existe.");

        try {
            // Buscar la cuenta bancaria existente por su ID
            CuentaBancariaEntidad cuentaExistente = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);
            if (cuentaExistente == null) {
                throw new NegocioException("La cuenta bancaria con ID " + id + " no existe.");
            }

            // Actualizar los valores de la cuenta bancaria con los proporcionados en el DTO
            cuentaExistente.setNumeroCuenta(cuentaBancaria.getNumeroCuenta());
            cuentaExistente.setClave(cuentaBancaria.getClave());
            cuentaExistente.setBanco(cuentaBancaria.getBanco());
            cuentaExistente.setEliminado(cuentaBancaria.isEliminado());

            // Guardar los cambios en la base de datos
            cuentaBancariaDAO.guardarCuentaBancaria(cuentaExistente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al modificar la cuenta bancaria.", ex);

        }
    }

}



    @Override
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaDTO cuentaBancaria, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) throws NegocioException {
        try {
            // Crear una instancia de CuentaBancariaEntidad con los datos del DTO
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.buscarBeneficiarioPorId(beneficiario.getId());
            if (beneficiarioEntidad == null) {
                throw new NegocioException("Beneficiario no encontrado con ID " + beneficiario.getId());
            }

            CuentaBancariaEntidad cuentaBancariaEntidad = new CuentaBancariaEntidad(

                cuentaBancaria.getNumeroCuenta(),
                cuentaBancaria.getClave(),
                cuentaBancaria.getBanco(),
                cuentaBancaria.isEliminado(),
                beneficiarioEntidad

                    cuentaBancaria.getNumeroCuenta(),
                    cuentaBancaria.getClave(),
                    cuentaBancaria.getBanco(),
                    cuentaBancaria.isEliminado(),
                    beneficiarioEntidad

            );

            // Guardar la cuenta bancaria en la base de datos
            cuentaBancariaDAO.guardarCuentaBancaria(cuentaBancariaEntidad);

        } catch (PersistenciaException ex) {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al guardar la cuenta bancaria con relaciones.", ex);
        }
    }

    
    private BeneficiarioEntidad convertirBeneficiarioDTOaEntidad(BeneficiarioDTO beneficiarioDTO){
        BeneficiarioEntidad beneficiarioEntidad = new BeneficiarioEntidad();
        beneficiarioEntidad.setApellidoMaterno(beneficiarioDTO.getApellidoMaterno());
        beneficiarioEntidad.setApellidoPaterno(beneficiarioDTO.getApellidoPaterno());
        beneficiarioEntidad.setClaveContrato(beneficiarioDTO.getClaveContrato());
        beneficiarioEntidad.setContrasena(beneficiarioDTO.getContrasena());
        beneficiarioEntidad.setNombres(beneficiarioDTO.getNombres());
        beneficiarioEntidad.setUsuario(beneficiarioDTO.getUsuario());
        return beneficiarioEntidad;
    }
    
    private BeneficiarioDTO convertirBeneficiarioDTOaEntidad(BeneficiarioEntidad beneficiarioEntidad){
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setApellidoMaterno(beneficiarioDTO.getApellidoMaterno());
        beneficiarioDTO.setApellidoPaterno(beneficiarioDTO.getApellidoPaterno());
        beneficiarioDTO.setClaveContrato(beneficiarioDTO.getClaveContrato());
        beneficiarioDTO.setContrasena(beneficiarioDTO.getContrasena());
        beneficiarioDTO.setNombres(beneficiarioDTO.getNombres());
        beneficiarioDTO.setUsuario(beneficiarioDTO.getUsuario());
        return beneficiarioDTO;
    }
    
    private List<CuentaBancariaDTO> convertirCuentasEntidadADTO(List<CuentaBancariaEntidad> listaCuentasEntidad) {
        List<CuentaBancariaDTO> listaCuentasDTO = new ArrayList<>();

        for (CuentaBancariaEntidad entidad : listaCuentasEntidad) {
            CuentaBancariaDTO dto = new CuentaBancariaDTO();
            dto.setId(entidad.getId());
            dto.setNumeroCuenta(entidad.getNumeroCuenta());
            dto.setClave(entidad.getClave());
            dto.setBanco(entidad.getBanco());
            dto.setEliminado(entidad.isEliminado());
            dto.setBeneficiario(convertirBeneficiarioDTOaEntidad(entidad.getBeneficiario()));
            // Añadir otros campos que se necesiten
            listaCuentasDTO.add(dto);
        }

        return listaCuentasDTO;
    }

    
    @Override
    public List<CuentaBancariaDTO> buscarCuentasBancarias(BeneficiarioDTO beneficiario) throws NegocioException {
        BeneficiarioEntidad beneficiarioEntidad = convertirBeneficiarioDTOaEntidad(beneficiario);
        
        try {
            List<CuentaBancariaEntidad> listaCuentas = cuentaBancariaDAO.buscarCuentasBancarias(beneficiarioEntidad);
            return convertirCuentasEntidadADTO(listaCuentas);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    

    public CuentaBancariaDTO buscarCuentaBancariaDTO(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {
        try {

            CuentaBancariaEntidad cuentaBancariaEntidad = convertirDTOAEntidad(cuentaBancariaDTO);
            CuentaBancariaEntidad cuentaBancariaEncontrada = cuentaBancariaDAO.buscarCuentaBancaria(cuentaBancariaEntidad);
            return convertirEntidadADTO(cuentaBancariaEncontrada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la cuenta bancaria", e);
        }
    }

    private CuentaBancariaEntidad convertirDTOAEntidad(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {

        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(conexion);
        BeneficiarioEntidad beneficiario = null;

        try {
            beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(cuentaBancariaDTO.getBeneficiario().getId());
        } catch (PersistenciaException ex) {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        CuentaBancariaEntidad cuentaBancariaEntidad = new CuentaBancariaEntidad();
        cuentaBancariaEntidad.setId(cuentaBancariaDTO.getId());
        cuentaBancariaEntidad.setBanco(cuentaBancariaDTO.getBanco());
        cuentaBancariaEntidad.setNumeroCuenta(cuentaBancariaDTO.getNumeroCuenta());
        cuentaBancariaEntidad.setClave(cuentaBancariaDTO.getClave());
        cuentaBancariaEntidad.setEliminado(cuentaBancariaDTO.isEliminado());
        cuentaBancariaEntidad.setBeneficiario(beneficiario);

        return cuentaBancariaEntidad;
    }

    private CuentaBancariaDTO convertirEntidadADTO(CuentaBancariaEntidad cuentaBancariaEntidad) throws NegocioException {
        
        BeneficiarioDTO beneficiarioDTO = convertirEntidadADTO(cuentaBancariaEntidad.getBeneficiario());

        
        CuentaBancariaDTO cuentaBancariaDTO = new CuentaBancariaDTO();
        cuentaBancariaDTO.setId(cuentaBancariaEntidad.getId());
        cuentaBancariaDTO.setBanco(cuentaBancariaEntidad.getBanco());
        cuentaBancariaDTO.setNumeroCuenta(cuentaBancariaEntidad.getNumeroCuenta());
        cuentaBancariaDTO.setClave(cuentaBancariaEntidad.getClave());
        cuentaBancariaDTO.setEliminado(cuentaBancariaEntidad.isEliminado());
        cuentaBancariaDTO.setBeneficiario(beneficiarioDTO);

        return cuentaBancariaDTO;
    }

}
