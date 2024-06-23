/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import Utileria.Utilidades;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import java.util.ArrayList;
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
    public void eliminarBeneficiario(Long id) throws NegocioException {
        try {
            // Buscar el beneficiario existente por su ID
            BeneficiarioEntidad beneficiarioExistente = beneficiarioDAO.buscarBeneficiarioPorId(id);
            if (beneficiarioExistente == null) {
                throw new NegocioException("El beneficiario con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            beneficiarioExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            beneficiarioDAO.eliminarBeneficiario(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al eliminar el beneficiario.", ex);
        }

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
            beneficiario.setEliminado(beneficiarioDTO.isEliminado());
            
            beneficiarioDAO.guardarBeneficiario(beneficiario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void modificarBeneficiario(Long id, BeneficiarioDTO beneficiario) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiarioExistente = beneficiarioDAO.buscarBeneficiarioPorId(id);
            if (beneficiarioExistente == null) {
                throw new NegocioException("El beneficiario con ID " + id + " no existe.");
            }

            beneficiarioExistente.setNombres(beneficiario.getNombres());
            beneficiarioExistente.setApellidoPaterno(beneficiario.getApellidoPaterno());
            beneficiarioExistente.setApellidoMaterno(beneficiario.getApellidoMaterno());
            beneficiarioExistente.setUsuario(beneficiario.getUsuario());
            beneficiarioExistente.setContrasena(beneficiario.getContrasena());
            beneficiarioExistente.setClaveContrato(beneficiario.getClaveContrato());
            beneficiarioExistente.setSaldo(beneficiario.getSaldo());

            beneficiarioDAO.modificarBeneficiario(beneficiarioExistente.getId(), beneficiarioExistente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al modificar el beneficiario.", ex);
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

    @Override
    public List<BeneficiarioDTO> buscarBeneficiarios(int limit, int pagina) throws NegocioException {
        try {
            this.esNumeroNegativo(limit);
            this.esNumeroNegativo(pagina);

            int offset = this.obtenerOFFSETMySQL(limit, pagina);

            List<BeneficiarioEntidad> listaBeneficiarios = this.beneficiarioDAO.buscarBeneficiarios(limit, offset);

            if (listaBeneficiarios == null || listaBeneficiarios.isEmpty()) {
                throw new NegocioException("No existen beneficiarios registrados");
            }
            return this.convertirBeneficiarioDTO(listaBeneficiarios);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
        }
    }

    private List<BeneficiarioDTO> convertirBeneficiarioDTO(List<BeneficiarioEntidad> beneficiarios) throws NegocioException {
        if (beneficiarios == null) {
            throw new NegocioException("No se pudieron obtener la lista de beneficiarios");
        }
        List<BeneficiarioDTO> beneficiariosDTO = new ArrayList<>();
        for (BeneficiarioEntidad beneficiario : beneficiarios) {
            BeneficiarioDTO dto = new BeneficiarioDTO();
            dto.setId(beneficiario.getId());
            dto.setNombres(beneficiario.getNombres());
            dto.setApellidoPaterno(beneficiario.getApellidoPaterno());
            dto.setApellidoMaterno(beneficiario.getApellidoMaterno());
            dto.setUsuario(beneficiario.getUsuario());
            dto.setContrasena(beneficiario.getContrasena());
            dto.setClaveContrato(beneficiario.getClaveContrato());
            dto.setSaldo(beneficiario.getSaldo());
            beneficiariosDTO.add(dto);
        }
        return beneficiariosDTO;
    }

    private void esNumeroNegativo(int numero) throws NegocioException {
        if (numero < 0) {
            throw new NegocioException("El numero ingresado es negativo bro");
        }
    }

    private int obtenerOFFSETMySQL(int limite, int pagina) throws NegocioException {
        int offset = new Utilidades().RegresarOFFSETMySQL(limite, pagina);
        this.esNumeroNegativo(offset);
        return offset;
    }

    
    private BeneficiarioDTO convertirEntidadADTO(BeneficiarioEntidad beneficiarioEntidad){
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setApellidoMaterno(beneficiarioEntidad.getApellidoMaterno());
        beneficiarioDTO.setApellidoPaterno(beneficiarioEntidad.getApellidoPaterno());
        beneficiarioDTO.setClaveContrato(beneficiarioEntidad.getClaveContrato());
        beneficiarioDTO.setContrasena(beneficiarioEntidad.getContrasena());
        beneficiarioDTO.setNombres(beneficiarioEntidad.getNombres());
        beneficiarioDTO.setUsuario(beneficiarioEntidad.getUsuario());
        
        return beneficiarioDTO;
        
    }
    
    @Override
    public BeneficiarioDTO buscarBeneficiarioPorId(Long idBeneficiario) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.buscarBeneficiarioPorId(idBeneficiario);
            return convertirEntidadADTO(beneficiarioEntidad);
        } catch (PersistenciaException ex) {
            System.out.println("Error");
        }
        return null;
    }
    
    
    @Override
    public BeneficiarioDTO loginBeneficiario(String usuario, String contrasena) throws NegocioException{
        
        try {
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.loginBeneficiario(usuario, contrasena);
            return convertirEntidadADTO(beneficiarioEntidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        } 
        
    }
    

}
