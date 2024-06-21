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
public interface IEstatusDAO {

    public void guardarEstatus(EstatusEntidad estatus) throws PersistenciaException;

    public void modificarEstatus(Long id, EstatusEntidad estatus) throws PersistenciaException;
}
