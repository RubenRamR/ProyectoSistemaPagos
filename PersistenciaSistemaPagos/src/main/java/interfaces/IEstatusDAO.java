/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.EstatusEntidad;
import excepciones.PersistenciaException;

/**
 *
 * @author caarl
 */
import java.util.List;

public interface IEstatusDAO {

    /**
     * Guarda un nuevo estatus en la base de datos.
     *
     * @param estatus El objeto EstatusEntidad a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    void guardarEstatus(EstatusEntidad estatus) throws PersistenciaException;

    /**
     * Modifica un estatus existente en la base de datos.
     *
     * @param id El ID del estatus a modificar.
     * @param estatus El objeto EstatusEntidad con los nuevos datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de modificación o si el estatus no existe.
     */
    void modificarEstatus(Long id, EstatusEntidad estatus) throws PersistenciaException;

    /**
     * Busca un estatus por su ID.
     *
     * @param idEstatus El ID del estatus a buscar.
     * @return El objeto EstatusEntidad encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda o si no se encuentra el estatus.
     */
    EstatusEntidad buscarEstatusPorId(Long idEstatus) throws PersistenciaException;

    /**
     * Busca todos los estatus en la base de datos.
     *
     * @return Una lista de todos los objetos EstatusEntidad.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    List<EstatusEntidad> buscarTodosLosEstatus() throws PersistenciaException;
    
    void eliminarEstatus(Long id) throws PersistenciaException;
}