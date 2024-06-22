/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.EstatusDTO;
import InterfacesNegocio.IEstatusBO;
import entidades.EstatusEntidad;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstatusDAO;
import java.util.logging.Logger;

public class EstatusNegocio implements IEstatusBO {

    private IEstatusDAO estatusDAO;
    private static final Logger LOGGER = Logger.getLogger(EstatusNegocio.class.getName());
    IConexionBD conexion;

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

