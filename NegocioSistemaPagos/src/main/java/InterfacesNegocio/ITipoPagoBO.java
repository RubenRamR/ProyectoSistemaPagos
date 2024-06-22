/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.TipoPagoDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author rramirez
 */
public interface ITipoPagoBO {
    void guardarTipoPago(TipoPagoDTO tipoPago) throws PersistenciaException;
    void modificarTipoPago(Long id, TipoPagoDTO tipoPago) throws PersistenciaException;
    TipoPagoDTO buscarTipoPagoPorId(Long idTipoPago) throws PersistenciaException;
}