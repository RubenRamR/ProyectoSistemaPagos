/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.EstatusDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author rramirez
 */
public interface IEstatusBO {

    void guardarEstatus(EstatusDTO estatusDTO) throws PersistenciaException;

    void modificarEstatus(Long id, EstatusDTO estatusDTO) throws PersistenciaException;

    EstatusDTO buscarEstatusPorId(Long id) throws PersistenciaException;

     void eliminarEstatus(Long id) throws PersistenciaException;
    
   
}