/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.EstatusDTO;
import excepciones.NegocioException;

/**
 *
 * @author rramirez
 */
public interface IEstatusNegocio {
    
    public void guardarEstatus(EstatusDTO estatus) throws NegocioException;

    public void modificarEstatus(Long id, EstatusDTO estatus) throws NegocioException;
}
