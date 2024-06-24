/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.EstatusDTO;
import entidades.EstatusEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstatusDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import InterfacesNegocio.IEstatusNegocio;

public class EstatusNegocio implements IEstatusNegocio {

    private final IEstatusDAO estatusDAO;
    private static final Logger LOGGER = Logger.getLogger(EstatusNegocio.class.getName());
    IConexionBD conexion;
    
    
    @Override
public void eliminarEstatus(Long id) {
    try {
        // Buscar el estatus existente por su ID
        EstatusEntidad estatusExistente = estatusDAO.buscarEstatusPorId(id);
        if (estatusExistente == null) {
            throw new NegocioException("El estatus con ID " + id + " no existe.");
        }

        // Cambiar la columna "eliminado" a true
        estatusExistente.setEliminado(true);

        // Guardar los cambios en la base de datos
        estatusDAO.guardarEstatus(estatusExistente);
    } catch (PersistenciaException ex) {
        LOGGER.log(Level.SEVERE, "Error al eliminar el estatus.", ex);
        try {
            throw new NegocioException("Error al eliminar el estatus.", ex);
        } catch (NegocioException ex1) {
            Logger.getLogger(EstatusNegocio.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }   catch (NegocioException ex) {
            Logger.getLogger(EstatusNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    

    public EstatusNegocio(IConexionBD conexion, IEstatusDAO estatusDAO) {
        this.conexion = conexion;
        this.estatusDAO = estatusDAO;
    }
  
    @Override
    public void guardarEstatus(EstatusDTO estatusDTO) throws PersistenciaException  {
        EstatusEntidad estatus = convertirADominio(estatusDTO);
        estatusDAO.guardarEstatus(estatus);
    }

    @Override
    public void modificarEstatus(Long id, EstatusDTO estatusDTO) throws PersistenciaException  {
        EstatusEntidad estatus = convertirADominio(estatusDTO);
        estatusDAO.modificarEstatus(id, estatus);
    }
    


    @Override
    public EstatusDTO buscarEstatusPorId(Long id) throws PersistenciaException  {
        EstatusEntidad estatus = estatusDAO.buscarEstatusPorId(id);
        return convertirADTO(estatus);
    }
    private EstatusEntidad convertirADominio(EstatusDTO estatusDTO) {
        // Convert DTO to Entity
        EstatusEntidad estatus = new EstatusEntidad();
        estatus.setId(estatusDTO.getId());
        estatus.setNombre(estatusDTO.getNombre());
        // Set other fields
        return estatus;
    }

    private EstatusDTO convertirADTO(EstatusEntidad estatus) {
        // Convert Entity to DTO
        EstatusDTO estatusDTO = new EstatusDTO();
        estatusDTO.setId(estatus.getId());
        estatusDTO.setNombre(estatus.getNombre());
        // Set other fields
        return estatusDTO;
    }
}

