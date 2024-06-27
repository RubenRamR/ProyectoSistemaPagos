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

/**
 * Clase que implementa la interfaz IEstatusNegocio para gestionar los estatus.
 */
public class EstatusNegocio implements IEstatusNegocio {

    private final IEstatusDAO estatusDAO;
    private static final Logger LOGGER = Logger.getLogger(EstatusNegocio.class.getName());
    IConexionBD conexion;

    /**
     * Constructor de la clase EstatusNegocio.
     *
     * @param conexion Objeto que gestiona la conexión a la base de datos.
     * @param estatusDAO Objeto que proporciona métodos para operaciones de
     * estatus en la base de datos.
     */
    public EstatusNegocio(IConexionBD conexion, IEstatusDAO estatusDAO) {
        this.conexion = conexion;
        this.estatusDAO = estatusDAO;
    }

    /**
     * Método para eliminar un estatus por su ID. Cambia la columna "eliminado"
     * a true en la entidad correspondiente y guarda los cambios.
     *
     * @param id ID del estatus a eliminar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la eliminación.
     */
    @Override
    public void eliminarEstatus(Long id) {
        try
        {
            // Buscar el estatus existente por su ID
            EstatusEntidad estatusExistente = estatusDAO.buscarEstatusPorId(id);
            if (estatusExistente == null)
            {
                throw new NegocioException("El estatus con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            estatusExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            estatusDAO.guardarEstatus(estatusExistente);
        } catch (PersistenciaException ex)
        {
            LOGGER.log(Level.SEVERE, "Error al eliminar el estatus.", ex);
            try
            {
                throw new NegocioException("Error al eliminar el estatus.", ex);
            } catch (NegocioException ex1)
            {
                Logger.getLogger(EstatusNegocio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (NegocioException ex)
        {
            Logger.getLogger(EstatusNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para guardar un nuevo estatus en la base de datos. Convierte un
     * objeto DTO en entidad y lo guarda utilizando el DAO correspondiente.
     *
     * @param estatusDTO DTO con los datos del estatus a guardar.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public void guardarEstatus(EstatusDTO estatusDTO) throws PersistenciaException {
        EstatusEntidad estatus = convertirADominio(estatusDTO);
        estatusDAO.guardarEstatus(estatus);
    }

    /**
     * Método para modificar un estatus existente en la base de datos. Convierte
     * un objeto DTO en entidad y realiza la modificación utilizando el DAO
     * correspondiente.
     *
     * @param id ID del estatus a modificar.
     * @param estatusDTO DTO con los nuevos datos del estatus.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public void modificarEstatus(Long id, EstatusDTO estatusDTO) throws PersistenciaException {
        EstatusEntidad estatus = convertirADominio(estatusDTO);
        estatusDAO.modificarEstatus(id, estatus);
    }

    /**
     * Método para buscar un estatus por su ID en la base de datos. Convierte la
     * entidad encontrada en un objeto DTO y lo retorna.
     *
     * @param id ID del estatus a buscar.
     * @return DTO con los datos del estatus encontrado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public EstatusDTO buscarEstatusPorId(Long id) throws PersistenciaException {
        EstatusEntidad estatus = estatusDAO.buscarEstatusPorId(id);
        return convertirADTO(estatus);
    }

    /**
     * Método privado para convertir un objeto DTO en una entidad de estatus.
     *
     * @param estatusDTO DTO con los datos del estatus.
     * @return Entidad de estatus con los datos del DTO.
     */
    private EstatusEntidad convertirADominio(EstatusDTO estatusDTO) {
        // Convert DTO to Entity
        EstatusEntidad estatus = new EstatusEntidad();
        estatus.setId(estatusDTO.getId());
        estatus.setNombre(estatusDTO.getNombre());
        // Set other fields
        return estatus;
    }

    /**
     * Método privado para convertir una entidad de estatus en un objeto DTO.
     *
     * @param estatus Entidad de estatus con los datos.
     * @return DTO con los datos de la entidad de estatus.
     */
    private EstatusDTO convertirADTO(EstatusEntidad estatus) {
        // Convert Entity to DTO
        EstatusDTO estatusDTO = new EstatusDTO();
        estatusDTO.setId(estatus.getId());
        estatusDTO.setNombre(estatus.getNombre());
        // Set other fields
        return estatusDTO;
    }
}
