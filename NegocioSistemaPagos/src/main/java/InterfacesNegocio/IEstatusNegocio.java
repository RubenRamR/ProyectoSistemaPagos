/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.EstatusDTO;
import excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los estados o
 * estatus.
 */
public interface IEstatusNegocio {

    /**
     * Método para guardar un estado o estatus en el sistema.
     *
     * @param estatusDTO El estado o estatus a guardar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void guardarEstatus(EstatusDTO estatusDTO) throws PersistenciaException;

    /**
     * Método para modificar un estado o estatus existente en el sistema.
     *
     * @param id ID del estado o estatus a modificar.
     * @param estatusDTO Los datos actualizados del estado o estatus.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void modificarEstatus(Long id, EstatusDTO estatusDTO) throws PersistenciaException;

    /**
     * Método para buscar un estado o estatus por su ID en el sistema.
     *
     * @param id ID del estado o estatus a buscar.
     * @return El estado o estatus encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    EstatusDTO buscarEstatusPorId(Long id) throws PersistenciaException;

    /**
     * Método para eliminar un estado o estatus del sistema.
     *
     * @param id ID del estado o estatus a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    void eliminarEstatus(Long id) throws PersistenciaException;
}
