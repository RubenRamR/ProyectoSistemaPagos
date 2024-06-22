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
    void guardarEstatus(EstatusDTO estatus) throws PersistenciaException;
    void modificarEstatus(Long id, EstatusDTO estatus) throws PersistenciaException;
    EstatusDTO buscarEstatusPorId(Long idEstatus) throws PersistenciaException;
}
